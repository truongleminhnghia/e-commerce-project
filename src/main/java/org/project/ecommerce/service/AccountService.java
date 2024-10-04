package org.project.ecommerce.service;

import org.project.ecommerce.dtos.requests.AccountCreationRequest;
import org.project.ecommerce.entities.Account;

import java.util.List;

public interface AccountService {

    public Account createAccount(AccountCreationRequest accountCreationRequest);

    public List<Account> getAllAccounts();

    public Account getAccountById(String id);
}
