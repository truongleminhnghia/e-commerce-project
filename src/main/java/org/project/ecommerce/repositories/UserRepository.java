package org.project.ecommerce.repositories;

import org.project.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);

    boolean existsById(String userId);

    boolean existsByUserName(String userName);

    User findByUserName(String userName);
}
