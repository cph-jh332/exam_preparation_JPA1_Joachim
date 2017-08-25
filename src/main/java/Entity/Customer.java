package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author craci
 */
@Entity
@NamedQueries({
    @NamedQuery(query = "select c from Customer c where c.email like :custEmail", name = "findCostumerByEmail"),
    @NamedQuery(name = "findCostumerByName", query = "select c from Customer c where c.name like :name"),
    @NamedQuery(name = "findAllCostumers", query = "select c from Customer c")
})
public class Customer implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    
    @OneToMany(mappedBy = "costumer", cascade = CascadeType.ALL)
    private List<Orders> orders = new ArrayList<Orders>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Costumer[ id=" + id + " ]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the order
     */
    public List<Orders> getOrder() {
        return orders;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(List<Orders> order) {
        this.orders = order;
    }
    
    public void addToOrdersList(Orders order){
        orders.add(order);
    }
    
}
