package com.example.badgesystem.Repository;

import com.example.badgesystem.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
