package hu.flowacademy.Bidder.application.Service;

import hu.flowacademy.Bidder.application.Domain.Product;
import hu.flowacademy.Bidder.application.Repository.ProductRepostiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepostiry productRepostiry;

    public Product save(Product product) {
        return productRepostiry.save(product);
    }
    public List<Product> getAll(){
        return productRepostiry.findAll();
    }
}
