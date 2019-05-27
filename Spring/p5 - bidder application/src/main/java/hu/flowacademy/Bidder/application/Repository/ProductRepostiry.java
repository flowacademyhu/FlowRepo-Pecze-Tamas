package hu.flowacademy.Bidder.application.Repository;

import hu.flowacademy.Bidder.application.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepostiry extends JpaRepository<Product, Long> {
}
