package hu.flowacademy.Bidder.application.Service;

import hu.flowacademy.Bidder.application.Domain.Bid;
import hu.flowacademy.Bidder.application.Repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BidService {
    @Autowired
    private BidRepository bidRepository;

    public Bid save(Bid bid) {
        return bidRepository.save(bid);
    }
    public List<Bid> getAll() {
        return bidRepository.findAll();
    }
    public Bid getById(Long id) {
        return bidRepository.findById(id).get();
    }
}
