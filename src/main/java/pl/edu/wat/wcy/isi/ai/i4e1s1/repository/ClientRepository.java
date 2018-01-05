package pl.edu.wat.wcy.isi.ai.i4e1s1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.wat.wcy.isi.ai.i4e1s1.entity.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query("select distinct c from Client c join c.orders order by c.lastName")
    List<Client> getClientsWithOrders();
}
