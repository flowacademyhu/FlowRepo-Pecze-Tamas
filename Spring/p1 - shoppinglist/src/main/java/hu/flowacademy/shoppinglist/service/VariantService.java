package hu.flowacademy.shoppinglist.service;

import hu.flowacademy.shoppinglist.domain.Variant;
import org.springframework.stereotype.Service;

@Service
public class VariantService {
    public Variant add (Variant var) { return Variant.add(var); }
}
