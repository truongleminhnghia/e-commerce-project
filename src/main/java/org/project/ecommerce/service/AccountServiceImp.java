package org.project.ecommerce.service;

import org.project.ecommerce.dtos.requests.AccountCreationRequest;
import org.project.ecommerce.entities.Account;
import org.project.ecommerce.exceptions.AppException;
import org.project.ecommerce.enums.ErrorCode;
import org.project.ecommerce.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired private AccountRepository accountRepository;

    @Override
    public Account createAccount(AccountCreationRequest accountCreationRequest) {
        Account account = new Account();
        if(accountRepository.existsByUserName(accountCreationRequest.getUserName())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        account.setUserName(accountCreationRequest.getUserName());
        account.setPassword(accountCreationRequest.getPassword());
        account.setStatus(true);
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
