package hu.flowacademy.Bidder.application.Controller;

import hu.flowacademy.Bidder.application.Domain.Bid;
import hu.flowacademy.Bidder.application.Service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bids")
public class BidController {
    @Autowired
    private BidService bidService;
    @GetMapping("/get")
    public ResponseEntity<List<Bid>> getBid() {
        return ResponseEntity.ok(bidService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<Bid> addBid(@RequestBody Bid bid) {
        return ResponseEntity.ok(bidService.save(bid));
    }
    @PutMapping("/update")
    public ResponseEntity<Bid> updateBid(@RequestBody Bid bid) {
        return ResponseEntity.ok(bidService.save(bid));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Bid> getBidById(@PathVariable Long  id) {
        return ResponseEntity.ok(bidService.getById(id));
    }
}
