package pl.edu.wat.wcy.isi.ai.i4e1s1.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @OneToMany(mappedBy = "client")
    List<Order> orders = new ArrayList<>();
}
