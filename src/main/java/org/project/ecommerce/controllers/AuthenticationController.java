package org.project.ecommerce.controllers;

import org.project.ecommerce.dtos.requests.AuthenticationRequest;
import org.project.ecommerce.dtos.responses.ApiResponse;
import org.project.ecommerce.dtos.responses.AuthenticationResponse;
import org.project.ecommerce.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/e-commerce/api/v1/auths")
public class AuthenticationController {
    @Autowired private AuthenticationService authenticationService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticationResponseApiResponse(@RequestBody AuthenticationRequest request) {
        boolean result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .data(AuthenticationResponse.builder()
                        .authenticated(result)
                        .build())
                .build();
    }

}
