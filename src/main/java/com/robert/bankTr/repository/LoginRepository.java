package com.robert.bankTr.repository;

import com.robert.bankTr.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login,Long> {
    Optional<Login> findByUsername(String us);
}
