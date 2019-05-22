package com.example.badgesystem.Repository;

import com.example.badgesystem.Domain.Badge;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BadgeRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private BadgeRepository badgeRepository;

    @Test
    public void whenBadgeGetName_thenReturnBadgeName() {
        Badge badgeShouldBeFound = new Badge("Pecze","Teapot","HTTP");
        entityManager.persist(badgeShouldBeFound);
        entityManager.flush();
        Badge foundBadge = badgeRepository.findByBadgeName(badgeShouldBeFound.getName());
        assertThat(foundBadge.getName()).isEqualTo(badgeShouldBeFound.getName());
    }
}
