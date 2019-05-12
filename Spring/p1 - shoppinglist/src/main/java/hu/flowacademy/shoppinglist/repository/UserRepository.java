package hu.flowacademy.shoppinglist.repository;

import hu.flowacademy.shoppinglist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public void deleteById(String username);
}