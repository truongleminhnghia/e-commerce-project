package org.project.ecommerce.repositories;

import org.project.ecommerce.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    boolean existsByUserName(String usename);
    Optional<Account> findByUserName(String usename);
}
