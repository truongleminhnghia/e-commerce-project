package org.project.ecommerce.controllers;


import jakarta.validation.Valid;
import org.project.ecommerce.dtos.requests.AccountCreationRequest;
import org.project.ecommerce.dtos.responses.ApiResponse;
import org.project.ecommerce.entities.Account;
import org.project.ecommerce.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/e-commerce/api/v1/accounts")
public class AccountController {
    @Autowired private AccountService accountService;

    @PostMapping("/create-account")
    ApiResponse<Account> createUser(@Valid @RequestBody AccountCreationRequest request) {
        ApiResponse<Account> apiResponse = new ApiResponse<>();
        apiResponse.setData(accountService.createAccount(request));
        return apiResponse;
    }

    @GetMapping("/all_account")
    List<Account> getAccount() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{account_id}")
    Account getAccount(@PathVariable("account_id") String id) {
        return accountService.getAccountById(id);
    }
}
