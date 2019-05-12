package hu.flowacademy.shoppinglist.domain;

import javax.persistence.*;

@Entity
@Table(name="variant")
public class Variant {

    @SequenceGenerator(name="generator",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "subtaskItemSeqGenerator", strategy = GenerationType.SEQUENCE)
    @Id
    private long id;

    @Column
    public String name;

    @Column
    private double price;

    @ManyToOne()
    @JoinColumn(name = "shopping_item_id", foreignKey = @ForeignKey(name = "fk_shoppingitem_variant"))
    private ShoppingItem shoppingItem;


    public Variant(String name, double price, ShoppingItem shoppingItem) {
        this.name = name;
        this.price = price;
        this.shoppingItem = shoppingItem;
    }

    @Transient
    private String shoppingItem_Id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ShoppingItem getShoppingItem() {
        return shoppingItem;
    }

    public void setShoppingItem(ShoppingItem shoppingItem) {
        this.shoppingItem = shoppingItem;
    }

    public String getShoppingItem_Id() {
        return shoppingItem_Id;
    }

    public void setShoppingItem_Id(String shoppingItem_Id) {
        this.shoppingItem_Id = shoppingItem_Id;
    }
}