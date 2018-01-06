package pl.edu.wat.wcy.isi.ai.i4e1s1;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.wcy.isi.ai.i4e1s1.entity.Client;
import pl.edu.wat.wcy.isi.ai.i4e1s1.entity.Order;
import pl.edu.wat.wcy.isi.ai.i4e1s1.entity.OrderDetail;
import pl.edu.wat.wcy.isi.ai.i4e1s1.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class CriteriaQueries {
    @Autowired
    EntityManager entityManager;

    public List<Product> getProductsOrderedAtLeastOnce() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<OrderDetail> order = query.from(OrderDetail.class);
        Join<OrderDetail, Product> join = order.join("product");
        query.select(join).distinct(true);

        return entityManager.createQuery(query).getResultList();
    }

    public List<Client> getClientsWithOrders(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> query = cb.createQuery(Client.class);
        Root<Order> order = query.from(Order.class);
        Join<Order, Client> join = order.join("client");
        query.select(join).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Order> getOrdersWithAtLeastXProducts(Integer minimum){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> query = cb.createQuery(Order.class);
        Root<OrderDetail> order = query.from(OrderDetail.class);
        Join<OrderDetail, Order>  join = order.join("order");
        query.select(join).distinct(true).having(cb.gt(cb.sum(order.get("quantity")), minimum));
        return entityManager.createQuery(query).getResultList();
    }
}
