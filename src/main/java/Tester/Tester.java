package Tester;

import Entity.Customer;
import Entity.ItemType;
import facade.DbFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author craci
 */
public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
        EntityManager em = emf.createEntityManager();
        DbFacade dbf = new DbFacade(em);
        dbf.createCostumer("John John", "lala");
        dbf.createCostumer("joachim", "lala");
        /*Costumer c = dbf.findCostumerById(1);
        System.out.println(c.getName());*/
        /*List<Costumer> c = dbf.findCostumerByEmail("lala");*/
        
        //List<Costumer> c = dbf.findCostumerByName("Joachim");
        List<Customer> c = dbf.findAllComstuers();
        for (Customer costumer : c) {
            System.out.println(costumer.getName());
        }
        dbf.createItemType();
        
        ItemType it = dbf.getItemType(1l);
        
        
        dbf.createOrder(c.get(0), it);
        dbf.createOrder(c.get(1), it);
        em.close();
    }
}
