package hu.flowacademy.shoppinglist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_list_item")
public class ShoppingListItem {

    @Id
    @Column(name = "id", length = 10)
    private String id;
    @Column(name ="name", length = 300)
    private String name;
    @Column(name ="category", length = 300)
    private String category;
    @Column(name ="quantity", length = 300)
    private String quantity;
    @Column(name ="price", length = 10)
    private int price;
    @Column(name ="comment", length = 300)
    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "ShoppingListItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                '}';
    }
}
