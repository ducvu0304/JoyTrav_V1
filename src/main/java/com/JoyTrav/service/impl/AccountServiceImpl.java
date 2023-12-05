package com.JoyTrav.service.impl;

import com.JoyTrav.dto.AccountDTO;
import com.JoyTrav.dto.SignUpForm;
import com.JoyTrav.model.Account;
import com.JoyTrav.repository.AccountRepository;
import com.JoyTrav.service.AccountService;
import com.JoyTrav.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private IdGenerator generator;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<Account> fetchALl() {
        return null;
    }

    @Override
    public Optional<Account> getById(Integer integer) {
        return null;
    }

    @Override
    public void create(Account account) {
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Optional<Account> findAccountByEmail(String email) {
        return accountRepository
                .findAll()
                .stream()
                .filter(account -> account.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public Account fetchAccountByEmail(String email) {
        return accountRepository.fetchAccountByEmail(email);
    }

    @Override
    public Account registerNewUserAccount(SignUpForm signupFormInfo) {
        Account account = new Account();

        account.setId(generator.generateID());
        account.setFirstname(signupFormInfo.getFirstName());
        account.setLastname(signupFormInfo.getLastName());
        account.setPassword(passwordEncoder.encode(signupFormInfo.getPassword()));
        account.setEmail(signupFormInfo.getEmail().toLowerCase());
        account.setStatus(true);
        account.setRole("USER");

        return accountRepository.save(account);
    }

    @Override
    public AccountDTO convertToAccountDTO(Account account) {
        AccountDTO accountDTO  = new AccountDTO();
        accountDTO.setFirstName(accountDTO.getFirstName());
        accountDTO.setEmail(accountDTO.getEmail());

        return accountDTO;
    }


}
