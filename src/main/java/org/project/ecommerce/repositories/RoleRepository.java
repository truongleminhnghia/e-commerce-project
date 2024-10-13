package org.project.ecommerce.repositories;

import org.project.ecommerce.entities.Role;
import org.project.ecommerce.enums.EnumRoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRoleName(EnumRoleName name);

}
