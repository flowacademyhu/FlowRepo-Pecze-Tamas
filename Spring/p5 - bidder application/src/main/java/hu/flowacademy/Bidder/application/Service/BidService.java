package hu.flowacademy.Bidder.application.Service;

import hu.flowacademy.Bidder.application.Domain.Bid;
import hu.flowacademy.Bidder.application.Domain.Product;
import hu.flowacademy.Bidder.application.Repository.BidRepository;
import hu.flowacademy.Bidder.application.Repository.ProductRepostiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BidService {
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private ProductRepostiry productRepostiry;

    public Bid save(Bid bid, Long productid) {
        if(productRepostiry.findById(productid).isEmpty()) {
            return null;
            //return bidRepository.save(bid);
        }
            Product product = productRepostiry.findById(productid).orElse(null);
            bid.setProducts(product);
                return bidRepository.save(bid);
        }


    public List<Bid> getAll() {
        return bidRepository.findAll();
    }
    public Bid getById(Long id) {
        return bidRepository.findById(id).get();
    }
}
