package hu.flowacademy.shoppinglist.repository;

import hu.flowacademy.shoppinglist.domain.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface VariantRepository extends JpaRepository<Variant,Long> {

    @Query("SELECT COUNT(variant.price) FROM Variant variant WHERE shoppingItem_id= ?1")
    public double sumPrice(String id);

    @Query("SELECT variant FROM Variant variant GROUP BY variant.id")
    public List<Variant> listVariants();
}