package org.project.ecommerce.service;

import org.project.ecommerce.dtos.requests.AuthenticationRequest;

public interface AuthenticationService {

    boolean authenticate(AuthenticationRequest request);
}
