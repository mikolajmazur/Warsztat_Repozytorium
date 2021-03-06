package pl.edu.wat.wcy.isi.ai.i4e1s1.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Product extends Auditable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private Double price;
    @OneToMany(mappedBy = "product",
            fetch = FetchType.LAZY)
    List<OrderDetail> orderDetails = new ArrayList<>();

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Product(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }
}
