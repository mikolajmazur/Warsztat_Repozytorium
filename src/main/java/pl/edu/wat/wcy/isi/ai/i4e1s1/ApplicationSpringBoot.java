package pl.edu.wat.wcy.isi.ai.i4e1s1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import pl.edu.wat.wcy.isi.ai.i4e1s1.entity.FoodProduct;
import pl.edu.wat.wcy.isi.ai.i4e1s1.entity.FurnitureProduct;
import pl.edu.wat.wcy.isi.ai.i4e1s1.entity.MilitaryExplosiveProduct;
import pl.edu.wat.wcy.isi.ai.i4e1s1.entity.Product;
import pl.edu.wat.wcy.isi.ai.i4e1s1.examples.CriteriaQueries;
import pl.edu.wat.wcy.isi.ai.i4e1s1.examples.MetamodelQueries;
import pl.edu.wat.wcy.isi.ai.i4e1s1.repository.ClientRepository;
import pl.edu.wat.wcy.isi.ai.i4e1s1.repository.OrderRepository;
import pl.edu.wat.wcy.isi.ai.i4e1s1.repository.ProductRepository;

@SpringBootApplication
@EnableJpaAuditing
public class ApplicationSpringBoot implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ApplicationSpringBoot.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CriteriaQueries exampleQueries;
    @Autowired
    private MetamodelQueries metamodelQueries;

    @Override
    public void run(String... strings) throws Exception {
        //showQueryExamples();
        //showAuditableExample();
    }

    private void showAuditableExample(){
        Product product = new Product("stól", 500.0);
        productRepository.save(product);
        System.out.println("-------------------------------");
        System.out.println("Audytowanie");
        System.out.println("-------------------------------");
        System.out.println("Data utworzenia produktu " + product.getCreatedDate());
    }

    private void showQueryExamples(){
        System.out.println("-------------------------------");
        System.out.println("Zapytania z użyciem criteria builder");
        System.out.println("-------------------------------");
        showProductCriteriaExample();
        showClientCriteriaExample();
        showOrderCriteriaExample();
        System.out.println("-------------------------------");
        System.out.println("Zapytania z użyciem metamodelu");
        System.out.println("-------------------------------");
        showProductMetamodelCriteriaExample();
        showClientMetamodelCriteriaExample();
        showOrderMetamodelCriteriaExample();
    }

    private void showClientCriteriaExample() {
        System.out.println();
        System.out.println("Wszyscy klienci:");
        clientRepository.findAll().forEach(c -> System.out.println(c.getLastName()));
        System.out.println();
        System.out.println("Klienci, którzy złożyli jakieś zamówienia:");
        exampleQueries.getClientsWithOrders().forEach(c -> System.out.println(c.getLastName()));
        System.out.println();
    }

    private void showProductCriteriaExample(){
        System.out.println();
        System.out.println("Wszystkie produkty:");
        productRepository.findAll().forEach(p -> System.out.println(p.getName()));
        System.out.println();
        System.out.println("Produkty zamówione co najmnniej raz:");
        exampleQueries.getProductsOrderedAtLeastOnce().forEach(p -> System.out.println(p.getName()));
        System.out.println();
    }

    private void showOrderCriteriaExample(){
        System.out.println();
        System.out.println("Liczba wszystkich zamówień:");
        System.out.println(orderRepository.findAll().size());
        System.out.println();
        System.out.println("Liczba zamówień z co najmniej 8 przedmiotami");
        System.out.println(exampleQueries.getOrdersWithAtLeastXProducts(8).size());
        System.out.println();
    }

    private void showClientMetamodelCriteriaExample() {
        System.out.println();
        System.out.println("Wszyscy klienci:");
        clientRepository.findAll().forEach(c -> System.out.println(c.getLastName()));
        System.out.println();
        System.out.println("Klienci, którzy złożyli jakieś zamówienia:");
        metamodelQueries.getClientsWithOrders().forEach(c -> System.out.println(c.getLastName()));
        System.out.println();
    }

    private void showProductMetamodelCriteriaExample(){
        System.out.println();
        System.out.println("Wszystkie produkty:");
        productRepository.findAll().forEach(p -> System.out.println(p.getName()));
        System.out.println();
        System.out.println("Produkty zamówione co najmnniej raz:");
        metamodelQueries.getProductsOrderedAtLeastOnce().forEach(p -> System.out.println(p.getName()));
        System.out.println();
    }

    private void showOrderMetamodelCriteriaExample(){
        System.out.println();
        System.out.println("Liczba wszystkich zamówień:");
        System.out.println(orderRepository.findAll().size());
        System.out.println();
        System.out.println("Liczba zamówień z co najmniej 8 przedmiotami");
        System.out.println(metamodelQueries.getOrdersWithAtLeastXProducts(8).size());
        System.out.println();
    }
}