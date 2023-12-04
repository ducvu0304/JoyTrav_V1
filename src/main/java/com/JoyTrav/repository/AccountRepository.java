package com.JoyTrav.repository;

import com.JoyTrav.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(
            value = "SELECT * FROM Account a WHERE a.email = ?1",
            nativeQuery = true)
    Account fetchAccountByEmail(String email);
}
