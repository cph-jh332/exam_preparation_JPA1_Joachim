package facade;

import Entity.Customer;
import Entity.ItemType;
import Entity.OrderLine;
import Entity.Orders;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.Order;

/**
 *
 * @author craci
 */
public class DbFacade {
    EntityManager em;
    
    public DbFacade(EntityManager em){
        this.em = em;
    }
    
    public void createCostumer(String name, String email){
        em.getTransaction().begin();
        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        em.persist(c);
        em.getTransaction().commit();
    }
    
    public Customer findCostumerById(long id){
        Customer c = em.find(Customer.class, id);
        return c;
    }
    
    public List<Customer> findCostumerByEmail(String custEmail){
        List<Customer> c = em.createNamedQuery("findCostumerByEmail").setParameter("custEmail", custEmail).getResultList();
        return c;
    }
    
    public List<Customer> findCostumerByName(String name){
        return em.createNamedQuery("findCostumerByName").setParameter("name", name).getResultList();
    }
    
    public List<Customer> findAllComstuers(){
        return em.createNamedQuery("findAllCostumers").getResultList();
    }
    
    public void createOrder(Customer cu, ItemType it){
        em.getTransaction().begin();
                
        OrderLine ol = new OrderLine();
        ol.setItemType(it);
        ol.setQuantity(3);
        
        Orders o = new Orders();
        o.addToOrderLine(ol);
        
        Customer c = cu;
        cu.addToOrdersList(o);
        
        ol.setOrders(o);
        o.setCostumer(cu);
        em.persist(c);
        em.getTransaction().commit();
    }
    
    public void createItemType(){
        em.getTransaction().begin();
        ItemType it = new ItemType();
        it.setId(1l);
        it.setDescription("I'm a lovely purse");
        it.setName("La purse");
        it.setPrice(100000000);
        em.persist(it);
        em.getTransaction().commit();
    }
    
    public ItemType getItemType(Long id){
        return em.find(ItemType.class, id);
    }
}
