package hu.flowacademy.shoppinglist.repository;

import hu.flowacademy.shoppinglist.domain.Variant;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Repository
public class VariantRepository {
    public Map<String, Variant> variant = new HashMap<>();

    public Variant add(RequestBody Variant var) {
        variant.put(variant.ge)
    }
}
