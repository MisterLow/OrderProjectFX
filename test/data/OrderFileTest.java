package data;

import content.Order;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexander
 */
public class OrderFileTest {

    private ArrayList<Order> orders;

    public OrderFileTest() {
    }

    @Before
    public void setUp() {
        orders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Order o = new Order(i);
            o.setCustomerID(i);
            o.setProduct("Prod: " + i);
            o.setShipping("Ship: " + i);
            orders.add(o);
        }

    }

    /**
     * Test of loadOrders method, of class OrderFile.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testLoadOrders() throws Exception {
        System.out.println("loadOrders");
        setUp();
        OrderFile.saveOrders(orders);
        boolean expResult = true;
        boolean result = false;
        ArrayList<Order> tempOrder = OrderFile.loadOrders();
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).getCustomerID());
            System.out.println(tempOrder.get(i).getCustomerID());
            if (tempOrder.get(i).getCustomerID() == orders.get(i).getCustomerID()) {
                result = true;
            } else {
                result = false;
            }
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of saveOrders method, of class OrderFile.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveOrders() throws Exception {
        System.out.println("saveOrders");
        setUp();
        OrderFile.saveOrders(orders);
    }
}
