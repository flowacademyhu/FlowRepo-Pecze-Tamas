package com.example.badgesystem.Repository;

import com.example.badgesystem.Domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BadgeRepository extends JpaRepository<Badge, String> {
    @Query("FROM Badge badge WHERE badge.name = ?1")
    public Badge findByBadgeName(@Param("name") String name);

}
