package org.project.ecommerce.service;

import org.project.ecommerce.dtos.requests.AuthenticationRequest;
import org.project.ecommerce.enums.ErrorCode;
import org.project.ecommerce.exceptions.AppException;
import org.project.ecommerce.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImp implements AuthenticationService{
    @Autowired private AccountRepository accountRepository;

    @Override
    public boolean authenticate(AuthenticationRequest request) {
        var account = accountRepository.findByUserName(request.getUserName()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(request.getPassword(), account.getPassword());
    }
}
