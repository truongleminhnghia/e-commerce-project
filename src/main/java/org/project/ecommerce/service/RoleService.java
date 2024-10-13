package org.project.ecommerce.service;

import org.project.ecommerce.entities.Role;
import org.project.ecommerce.enums.EnumRoleName;

public interface RoleService {
    Role getRoleName(EnumRoleName roleName);
}
