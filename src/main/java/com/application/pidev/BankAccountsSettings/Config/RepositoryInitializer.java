package com.application.pidev.BankAccountsSettings.Config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.application.pidev.BankAccountsSettings.Utils.Constants;
import com.application.pidev.Entity.*;
import com.application.pidev.Entity.Enums.*;
import com.application.pidev.Entity.User.Address;
import com.application.pidev.Entity.User.User;
import com.application.pidev.Entity.User.UserRole;
import com.application.pidev.Repository.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class RepositoryInitializer {
    private final BankAccountRepository bankAccountRepository;

    private final CurrencyTypeRepository currencyTypeRepository;

    private final SaldoRepository saldoRepository;

    private final BankAccountTypeRepository bankAccountTypeRepository;

    private final Constants constants;

    private final UserRoleRepository userRoleRepository;

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;


    private final BCryptPasswordEncoder encoder;

   

    @Autowired
    public RepositoryInitializer(BankAccountRepository bankAccountRepository,
                                 CurrencyTypeRepository currencyTypeRepository,
                                 SaldoRepository saldoRepository,
                                 BankAccountTypeRepository bankAccountTypeRepository,
                                 Constants constants,
                                 UserRoleRepository userRoleRepository,
                                 UserRepository userRepository,
                                 AddressRepository addressRepository,
                                 BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bankAccountRepository = bankAccountRepository;
        this.currencyTypeRepository = currencyTypeRepository;
        this.saldoRepository = saldoRepository;
        this.bankAccountTypeRepository = bankAccountTypeRepository;
        this.constants = constants;
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.encoder = bCryptPasswordEncoder;
    }

    @Bean
    public InitializingBean intializeRepo() {
        return () -> {

            if (userRoleRepository.findAll().isEmpty()) {
                userRoleRepository.save(UserRole.builder().userType(UserRole.UserType.ROLE_EMPLOYEE).build());
                userRoleRepository.save(UserRole.builder().userType(UserRole.UserType.ROLE_USER).build());
                userRoleRepository.save(UserRole.builder().userType(UserRole.UserType.ROLE_ADMIN).build());
            }

            if (userRepository.findAll().isEmpty()) {
                Address address = Address.builder()
                    .city("Tunis")
                    .houseNumber("08")
                    .name("Tunisia")
                    .surname("Ghazala")
                    .phoneNumber("2036")
                    .postCode("20-36")
                    .dateOfBirth(Instant.now())
                    .street("ESPRIT")
                    .build();

                User user = User.builder()
                    .credentials(false)
                    .email("asma.nouri@esprit.tn")
                    .enabled(true)
                    .expired(false)
                    .locked(false)
                    .password(encoder.encode("asmanouri"))
                    .userRoles(Collections.singleton(userRoleRepository.findByUserType(UserRole.UserType.ROLE_ADMIN)))
                    .transactionTemplates(new HashSet<>())
                    .identifier("11111111")
                    .bankAccounts(new HashSet<>())
                    .address(address)
                    .build();

                userRepository.save(user);

                Address address2 = Address.builder()
                    .city("Tunis")
                    .houseNumber("32")
                    .name("Asma")
                    .surname("Nouri")
                    .phoneNumber("52103314")
                    .postCode("60-201")
                    .dateOfBirth(Instant.now())
                    .street("Ariana")
                    .build();


                User user2 = User.builder()
                    .credentials(false)
                    .email("onss.akaichi@esprit.tn")
                    .enabled(true)
                    .expired(false)
                    .locked(false)
                    .password(encoder.encode("onsakaichi"))
                    .userRoles(Collections.singleton(userRoleRepository.findByUserType(UserRole.UserType.ROLE_USER)))
                    .transactionTemplates(new HashSet<>())
                    .identifier("22222222")
                    .bankAccounts(new HashSet<>())
                    .address(address2)
                    .build();

                userRepository.save(user2);

                Address address3 = Address.builder()
                    .city("Tunis")
                    .houseNumber("92")
                    .name("Razi")
                    .surname("Fertani")
                    .dateOfBirth(Instant.now())
                    .phoneNumber("692193823")
                    .postCode("50-221")
                    .street("Sokra")
                    .build();

                User user3 = User.builder()
                    .credentials(false)
                    .email("razi.fertani@esprit.tn")
                    .enabled(true)
                    .expired(false)
                    .locked(false)
                    .password(encoder.encode("razifertani"))
                    .userRoles(Collections.singleton(userRoleRepository.findByUserType(UserRole.UserType.ROLE_EMPLOYEE)))
                    .transactionTemplates(new HashSet<>())
                    .identifier("33333333")
                    .bankAccounts(new HashSet<>())
                    .address(address3)
                    .build();

                userRepository.save(user3);
            }

            if (currencyTypeRepository.findAll().isEmpty()) {
                CurrencyType eur = CurrencyType.builder()
                    .name("EUR")
                    .exchangeRate(1f)
                    .build();

                CurrencyType usd = CurrencyType.builder()
                    .name("USD")
                    .exchangeRate(3.88f)
                    .build();

                CurrencyType tnd = CurrencyType.builder()
                    .name("TND")
                    .exchangeRate(4.23f)
                    .build();

              

                currencyTypeRepository.save(eur);
                currencyTypeRepository.save(usd);
                currencyTypeRepository.save(tnd);
                           }

            if (bankAccountTypeRepository.findAll().isEmpty()) {
          
                BankAccType bankAccType2 = BankAccType.builder()
                    .bankAccountType(BankAccountType.STANDARD)
                    .exchangeCurrencyCommission((float) constants.CURRENCY_CONVERT_COMMISSION)
                    .transactionComission((float) constants.SINGLE_CURRENCY_TRANSFER_COMMISSION)
                    .build();

                bankAccountTypeRepository.save(bankAccType2);

                BankAccType bankAccType3 = BankAccType.builder()
                    .bankAccountType(BankAccountType.STUDENT)
                    .exchangeCurrencyCommission((float) constants.CURRENCY_CONVERT_COMMISSION)
                    .transactionComission((float) constants.STUDENT_CURRENCY_TRANSFER_COMMISSION)
                    .build();

                bankAccountTypeRepository.save(bankAccType3);
            }

            if (bankAccountRepository.findAll().isEmpty()) {
                BankAccType single = bankAccountTypeRepository.findByBankAccountType(BankAccountType.STANDARD);
                BankAccType student = bankAccountTypeRepository.findByBankAccountType(BankAccountType.STUDENT);

                BankAccount bankAccount = BankAccount.builder()
                    .bankAccType(single)
                    .number("12341234123412341234123412")
                    .removed(false)
                    .saldos(new HashSet<>())
                    .transactions(new HashSet<>())
                    .user(userRepository.findByIdentifier("11111111").get())
                    .build();

                bankAccountRepository.save(bankAccount);

                Set<Saldo> saldos = currencyTypeRepository.findAll()
                    .stream()
                    .map(e -> saldoRepository.save(Saldo.builder()
                        .balance(new BigDecimal(100f))
                        .currencyType(e)
                        .bankAccount(bankAccount)
                        .build()))
                    .collect(Collectors.toSet());


                BankAccount bankAccount2 = BankAccount.builder()
                    .bankAccType(single)
                    .number("67896789678967896789678967")
                    .removed(false)
                    .saldos(new HashSet<>())
                    .transactions(new HashSet<>())
                    .user(userRepository.findByIdentifier("22222222").get())
                    .build();

                bankAccountRepository.save(bankAccount2);

                Set<Saldo> saldos2 = currencyTypeRepository.findAll()
                    .stream()
                    .map(e -> saldoRepository.save(Saldo.builder()
                        .balance(new BigDecimal(100f))
                        .currencyType(e)
                        .bankAccount(bankAccount2)
                        .build()))
                    .collect(Collectors.toSet());

                BankAccount bankAccount3 = BankAccount.builder()
                    .bankAccType(student)
                    .number("56785678567856785678567867")
                    .removed(false)
                    .saldos(new HashSet<>())
                    .transactions(new HashSet<>())
                    .user(userRepository.findByIdentifier("33333333").get())
                    .build();

                bankAccountRepository.save(bankAccount3);

                Set<Saldo> saldos3 = currencyTypeRepository.findAll()
                    .stream()
                    .filter(e -> Objects.equals(e.getName(), "PLN"))
                    .map(e -> saldoRepository.save(Saldo.builder()
                        .balance(new BigDecimal(100f))
                        .currencyType(e)
                        .bankAccount(bankAccount3)
                        .build()))
                    .collect(Collectors.toSet());


            }

            
        };
    }
}
