package org.project.ecommerce.service;


import org.project.ecommerce.dtos.requests.UserRegisterRequest;
import org.project.ecommerce.dtos.responses.UserResphonse;
import org.project.ecommerce.entities.User;

public interface UserService {

     User save(UserRegisterRequest request);
     UserResphonse getUserByEmail(String email);
     UserResphonse getUserById(String id);
     UserResphonse getByUsername(String username);

}
