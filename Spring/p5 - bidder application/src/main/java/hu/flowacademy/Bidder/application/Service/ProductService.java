package hu.flowacademy.Bidder.application.Service;

import hu.flowacademy.Bidder.application.Domain.Bid;
import hu.flowacademy.Bidder.application.Domain.Product;
import hu.flowacademy.Bidder.application.Repository.BidRepository;
import hu.flowacademy.Bidder.application.Repository.ProductRepostiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepostiry productRepostiry;

    @Autowired
    private BidRepository bidRepository;

    public Product save(Product product) {
        return productRepostiry.save(product);
    }
    public List<Product> getAll(){
        return productRepostiry.findAll();
    }
    public Product getOneProduct(Long id) {
        return productRepostiry.getOne(id);
    }
    /*public Product save(Product product){
        Optional<Bid> bid = bidRepository.findById(product.getId());
        if(bid.isPresent()) {
            product.setBid(bid.get());
        }
    }*/
}
