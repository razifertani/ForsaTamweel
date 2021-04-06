package com.application.pidev.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.pidev.BankAccountsSettings.Exceptions.ApiException;
import com.application.pidev.BankAccountsSettings.Mappers.TransactionMapper;
import com.application.pidev.BankAccountsSettings.Utils.Constants;
import com.application.pidev.BankAccountsSettings.Utils.CurrencyConverter;
import com.application.pidev.Entity.BankAccount;
import com.application.pidev.Entity.CurrencyType;
import com.application.pidev.Entity.Saldo;
import com.application.pidev.Entity.Transaction;
import com.application.pidev.Entity.In.TransactionIn;
import com.application.pidev.Entity.Out.TransactionOut;
import com.application.pidev.Repository.BankAccountRepository;
import com.application.pidev.Repository.CurrencyTypeRepository;
import com.application.pidev.Repository.SaldoRepository;
import com.application.pidev.Repository.TransactionRepository;
import com.application.pidev.Service.Interfaces.TransactionService;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
	private final CurrencyTypeRepository currencyTypeRepository;

	private final BankAccountRepository bankAccountRepository;

	private final SaldoRepository saldoRepository;

	private final TransactionRepository transactionRepository;
/*
	private final WithdrawRepository withdrawRepository;
*/
	private final TransactionMapper transactionMapper;


	private final Constants constants;

	private final CurrencyConverter currencyConverter;

	@Autowired
	public TransactionServiceImpl(CurrencyTypeRepository currencyTypeRepository,
			BankAccountRepository bankAccountRepository, SaldoRepository saldoRepository, Constants constants,
			TransactionRepository transactionRepository, TransactionMapper transactionMapper,  
			CurrencyConverter currencyConverter) {
		this.currencyTypeRepository = currencyTypeRepository;
		this.bankAccountRepository = bankAccountRepository;
		this.saldoRepository = saldoRepository;
		this.constants = constants;
		this.transactionRepository = transactionRepository;
		// this.withdrawRepository = withdrawRepository;
		this.transactionMapper = transactionMapper;
		this.currencyConverter = currencyConverter;
	}

	@Override
	public TransactionOut create(TransactionIn transactionIn) {
		transactionIn.setSourceAccountNumber(transactionIn.getSourceAccountNumber().replace(" ", ""));
		transactionIn.setDestinedAccountNumber(transactionIn.getDestinedAccountNumber().replace(" ", ""));

		CurrencyType sourceCurrency = currencyTypeRepository.findByName(transactionIn.getSourceCurrency())
				.orElseThrow(() -> new ApiException("Exception.sourceCurrencyNotFound", null));
		CurrencyType destCurrency = currencyTypeRepository.findByName(transactionIn.getDestinedCurrency())
				.orElseThrow(() -> new ApiException("Exception.destCurrencyNotFound", null));
		BankAccount destinedBankAccount = bankAccountRepository
				.findByNumberAndRemovedFalse(transactionIn.getDestinedAccountNumber())
				.orElseThrow(() -> new ApiException("Exception.notFoundBankAcc",
						new String[] { transactionIn.getDestinedAccountNumber() }));
		BankAccount sourceBankAccount = bankAccountRepository
				.findByNumberAndRemovedFalse(transactionIn.getSourceAccountNumber())
				.orElseThrow(() -> new ApiException("Exception.notFoundBankAcc",
						new String[] { transactionIn.getSourceAccountNumber() }));

		Saldo sourceSaldo = sourceBankAccount.getSaldos().stream().filter(e -> e.getCurrencyType() == sourceCurrency)
				.findFirst().get();

		Saldo destSaldo = getDestSaldo(destCurrency, destinedBankAccount);

		if (sourceSaldo.getBalance().floatValue() < transactionIn.getBalance())
			throw new ApiException("Exception.notEnoughBalanceSaldo", null);

		BigDecimal balance = currencyConverter.convertCurrency(transactionIn.getBalance(), sourceCurrency,
				destSaldo.getCurrencyType());

		BigDecimal balanceWithCommission = getBalanceWithCommission(sourceBankAccount, balance);

		sourceSaldo.setBalance(sourceSaldo.getBalance().subtract(BigDecimal.valueOf(transactionIn.getBalance())));
		destSaldo.setBalance(destSaldo.getBalance().add(balanceWithCommission));

		return transactionMapper.entityToDTO(transactionRepository.save(Transaction.builder()
				.balance(BigDecimal.valueOf(transactionIn.getBalance())).balanceWithCommission(balanceWithCommission)
				.date(Instant.now()).destinedBankAccount(destinedBankAccount).sourceBankAccount(sourceBankAccount)
				.title(transactionIn.getTitle()).sourceCurrencyType(sourceCurrency)
				.destinedCurrencyType(destSaldo.getCurrencyType()).build()));
	}

	////////
/*
	@Override
	public WithdrawOut withdraw(WithdrawIn withdrawIn) {
		withdrawIn.setSourceAccountNumber(withdrawIn.getSourceAccountNumber().replace(" ", ""));

		CurrencyType sourceCurrency = currencyTypeRepository.findByName(withdrawIn.getSourceCurrency())
				.orElseThrow(() -> new ApiException("Exception.sourceCurrencyNotFound", null));

		BankAccount sourceBankAccount = bankAccountRepository
				.findByNumberAndRemovedFalse(withdrawIn.getSourceAccountNumber())
				.orElseThrow(() -> new ApiException("Exception.notFoundBankAcc",
						new String[] { withdrawIn.getSourceAccountNumber() }));

		Saldo sourceSaldo = sourceBankAccount.getSaldos().stream().filter(e -> e.getCurrencyType() == sourceCurrency)
				.findFirst().get();

		// Saldo destSaldo = getDestSaldo(destCurrency, destinedBankAccount);

		if (sourceSaldo.getBalance().floatValue() < withdrawIn.getBalance())
			throw new ApiException("Exception.notEnoughBalanceSaldo", null);

		 BigDecimal balance = currencyConverter.convertCurrency(withdrawIn.getBalance(), sourceCurrency, sourceCurrency); 

		 BigDecimal balanceWithCommission = getBalanceWithCommission(sourceBankAccount, balance); 

		sourceSaldo.setBalance(sourceSaldo.getBalance().subtract(BigDecimal.valueOf(withdrawIn.getBalance())));

		return withdrawMapper.entityToDTO(withdrawRepository.save(Withdraw.builder()
				.balance(BigDecimal.valueOf(withdrawIn.getBalance())).balanceWithCommission(balanceWithCommission)
				.date(Instant.now()).sourceBankAccount(sourceBankAccount)
				.title(withdrawIn.getTitle()).sourceCurrencyType(sourceCurrency)
				.build()));
	}
*/
	private Saldo getDestSaldo(CurrencyType destCurrency, BankAccount destinedBankAccount) {
		return destinedBankAccount.getSaldos().stream().filter(e -> e.getCurrencyType() == destCurrency).findFirst()
				.orElse(destinedBankAccount.getSaldos().stream()
						.filter(e -> Objects.equals(e.getCurrencyType().getName(), "PLN")).findFirst().get());
	}

	private BigDecimal getBalanceWithCommission(BankAccount sourceBankAccount, BigDecimal balance) {
		return BigDecimal.valueOf(balance.doubleValue()
				- ((sourceBankAccount.getBankAccType().getTransactionComission() / 100d) * balance.doubleValue()))
				.setScale(2, RoundingMode.DOWN);
	}

	@Override
	public List<TransactionOut> findAll() {
		return transactionRepository.findAll().stream().map(transactionMapper::entityToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<TransactionOut> findAllByBankAccountId(Long bankAccountId) {
		return transactionRepository.findTransactionsByBankAccountId(bankAccountId).stream()
				.map(transactionMapper::entityToDTO).collect(Collectors.toList());
	}

}
