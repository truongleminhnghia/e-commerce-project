package org.project.ecommerce.service;

import org.project.ecommerce.dtos.requests.UserRegisterRequest;
import org.project.ecommerce.dtos.responses.UserResphonse;
import org.project.ecommerce.entities.Role;
import org.project.ecommerce.entities.User;
import org.project.ecommerce.enums.EnumGenner;
import org.project.ecommerce.enums.EnumRoleName;
import org.project.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired private RoleService roleService;

    @Override
    public User save(UserRegisterRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        if(request.getGener().equalsIgnoreCase("nam")) {
            user.setGenner(EnumGenner.MALE);
        } else {
            user.setGenner(EnumGenner.FE_MALE);
        }
        user.setBirthDate(request.getBirthDate());
        if(!request.getPassword().equals(request.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        Role role = roleService.getRoleName(EnumRoleName.ROLE_USER);
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public UserResphonse getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserResphonse getUserById(String id) {
        return null;
    }

    @Override
    public UserResphonse getByUsername(String username) {
        return null;
    }
}
