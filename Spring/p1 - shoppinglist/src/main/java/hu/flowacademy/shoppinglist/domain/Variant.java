package hu.flowacademy.shoppinglist.domain;

import javax.persistence.*;

@Entity
@Table(name="variant_table")
public class Variant {
    @Id
    @Column(name="id")
    @SequenceGenerator(name="VariantIdGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator="VariantIdGenerator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "replaced_item", foreignKey = @ForeignKey(name = "fk_replaced_item"))
    private ShoppingListItem ReplacedItem;

    @Column
    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingListItem getReplacedItem() {
        return ReplacedItem;
    }

    public void setReplacedItem(ShoppingListItem replacedItem) {
        ReplacedItem = replacedItem;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Variant{" +
                "id=" + id +
                ", ReplacedItem=" + ReplacedItem +
                ", price=" + price +
                '}';
    }

    public Variant() {
    }

    public Variant(Long id) {
        this.id = id;
    }

    public Variant(Long id, ShoppingListItem replacedItem, Long price) {
        this.id = id;
        ReplacedItem = replacedItem;
        this.price = price;
    }
}
