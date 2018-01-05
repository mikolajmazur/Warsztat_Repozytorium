package pl.edu.wat.wcy.isi.ai.i4e1s1.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer quantity;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Order order;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
        order.getDetails().add(this);
    }
}
