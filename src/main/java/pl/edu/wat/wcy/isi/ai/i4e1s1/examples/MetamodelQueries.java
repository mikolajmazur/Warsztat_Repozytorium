package pl.edu.wat.wcy.isi.ai.i4e1s1.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.wcy.isi.ai.i4e1s1.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class MetamodelQueries {
    @Autowired
    EntityManager entityManager;

    public List<Product> getProductsOrderedAtLeastOnce() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<OrderDetail> order = query.from(OrderDetail.class);
        Join<OrderDetail, Product> join = order.join(OrderDetail_.product);
        query.select(join).distinct(true);

        return entityManager.createQuery(query).getResultList();
    }

    public List<Client> getClientsWithOrders(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> query = cb.createQuery(Client.class);
        Root<Order> order = query.from(Order.class);
        Join<Order, Client> join = order.join(Order_.client);
        query.select(join).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Order> getOrdersWithAtLeastXProducts(Integer minimum){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> query = cb.createQuery(Order.class);
        Root<OrderDetail> order = query.from(OrderDetail.class);
        Join<OrderDetail, Order>  join = order.join(OrderDetail_.order);
        query.select(join).distinct(true).having(cb.gt(cb.sum(order.get(OrderDetail_.quantity)), minimum));
        return entityManager.createQuery(query).getResultList();
    }
}
