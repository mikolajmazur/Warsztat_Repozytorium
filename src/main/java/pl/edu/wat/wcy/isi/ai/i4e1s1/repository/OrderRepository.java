package pl.edu.wat.wcy.isi.ai.i4e1s1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.edu.wat.wcy.isi.ai.i4e1s1.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select sum(od.quantity * p.price) " +
            "from Order o " +
            "join o.details od " +
            "join od.product p " +
            "where o.id = :orderId")
    double getOrderSum(@Param(value = "orderId") Integer orderId);
}
