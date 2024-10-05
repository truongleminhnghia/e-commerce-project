package org.project.ecommerce.service;

import org.project.ecommerce.dtos.requests.AccountCreationRequest;
import org.project.ecommerce.entities.Account;
import org.project.ecommerce.exceptions.AppException;
import org.project.ecommerce.enums.ErrorCode;
import org.project.ecommerce.mappers.AccountMapper;
import org.project.ecommerce.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired private AccountRepository accountRepository;
    @Autowired private AccountMapper accountMapper;

    @Override
    public Account createAccount(AccountCreationRequest accountCreationRequest) {
        if(accountRepository.existsByUserName(accountCreationRequest.getUserName())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        Account account = accountMapper.toAccount(accountCreationRequest);
        account.setStatus(true);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        account.setPassword(passwordEncoder.encode(accountCreationRequest.getPassword()));
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(String id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
    }
}
