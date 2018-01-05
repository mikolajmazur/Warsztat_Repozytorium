package pl.edu.wat.wcy.isi.ai.i4e1s1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.edu.wat.wcy.isi.ai.i4e1s1.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p " +
            "join p.orderDetails od " +
            "group by p.id " +
            "having sum(od.quantity) > :minNumber")
    List<Product> getProductsSoldAtLeastXTimes(@Param(value = "minNumber") long minimalNumber);
}