/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public OrderFileTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of loadOrders method, of class OrderFile.
     */
    @Test
    public void testLoadOrders() throws Exception {
        System.out.println("loadOrders");
        ArrayList<Order> expResult = null;
        ArrayList<Order> result = OrderFile.loadOrders();
        assertEquals(expResult, result);
        for(Order order:result){
            System.out.println(order.getCustomerID());
        }
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveOrders method, of class OrderFile.
     */
    @Test
    public void testSaveOrders() throws Exception {
        System.out.println("saveOrders");
        ArrayList<Order> orders = new ArrayList<>();
        Order o = new Order(1);
        o.setProduct("1");
        o.setCustomerID(1);
        o.setShipping("1");
        orders.add(o);
        OrderFile.saveOrders(orders);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
