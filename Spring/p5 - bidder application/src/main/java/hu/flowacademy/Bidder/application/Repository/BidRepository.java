package hu.flowacademy.Bidder.application.Repository;

import hu.flowacademy.Bidder.application.Domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

}
