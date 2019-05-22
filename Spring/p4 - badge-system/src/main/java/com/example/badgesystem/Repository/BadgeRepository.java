package com.example.badgesystem.Repository;

import com.example.badgesystem.Domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge, String> {
}
