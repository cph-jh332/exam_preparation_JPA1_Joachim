package Entity;

import Entity.Customer;
import Entity.OrderLine;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-24T14:33:36")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile ListAttribute<Orders, OrderLine> orderLine;
    public static volatile SingularAttribute<Orders, Long> id;
    public static volatile SingularAttribute<Orders, Customer> costumer;

}