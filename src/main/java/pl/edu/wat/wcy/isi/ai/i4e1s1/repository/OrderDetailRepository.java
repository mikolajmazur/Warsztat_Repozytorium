package pl.edu.wat.wcy.isi.ai.i4e1s1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wat.wcy.isi.ai.i4e1s1.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
