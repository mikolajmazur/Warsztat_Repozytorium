package pl.edu.wat.wcy.isi.ai.i4e1s1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double price;
    @OneToMany(mappedBy = "product",
            fetch = FetchType.LAZY)
    @JsonIgnore
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
