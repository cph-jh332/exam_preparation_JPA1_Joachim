package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author craci
 */
@Entity
public class Orders implements Serializable {

    @ManyToOne
    private Customer costumer;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderLine> orderLine = new ArrayList<OrderLine>();

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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Order[ id=" + id + " ]";
    }

    /**
     * @return the OrderLine
     */
    public List<OrderLine> getOrderLine() {
        return orderLine;
    }

    /**
     * @param OrderLine the OrderLine to set
     */
    public void setOrderLine(List<OrderLine> OrderLine) {
        this.orderLine = OrderLine;
    }
    
    public void addToOrderLine(OrderLine orderLine){
        this.orderLine.add(orderLine);
    }

    /**
     * @return the costumer
     */
    public Customer getCostumer() {
        return costumer;
    }

    /**
     * @param costumer the costumer to set
     */
    public void setCostumer(Customer costumer) {
        this.costumer = costumer;
    }
    
}
