package com.robert.bankTr.repository;

import com.robert.bankTr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
