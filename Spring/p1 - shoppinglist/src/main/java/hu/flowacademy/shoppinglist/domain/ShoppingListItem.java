package hu.flowacademy.shoppinglist.domain;

import javax.persistence.*;

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
    @OneToOne
    @JoinColumn(name="user_id", foreignKey = @ForeignKey(name = "fk_shoppinglistitem_userid"))
    private User user;

    public ShoppingListItem(User user) {
        this.user = user;
    }

    public ShoppingListItem(String id) {
        this.id = id;
    }

    public ShoppingListItem() {
    }

    public ShoppingListItem(String ex2, String s, boolean b, User user1) {
    }

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

    public ShoppingListItem(String id, String name, String category, String quantity, int price, String comment, User user) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.comment = comment;
        this.user = user;
    }
}
