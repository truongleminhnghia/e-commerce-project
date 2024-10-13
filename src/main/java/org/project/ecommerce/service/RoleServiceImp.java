package org.project.ecommerce.service;

import org.project.ecommerce.entities.Role;
import org.project.ecommerce.enums.EnumRoleName;
import org.project.ecommerce.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService{
    @Autowired private RoleRepository roleRepository;

    @Override
    public Role getRoleName(EnumRoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
