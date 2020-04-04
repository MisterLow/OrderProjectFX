package panes;

import content.Order;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alexander
 */
public class ResultPane extends GridPane {

    private final Label lblOrder = new Label("Order: ");
    private final Label lblCustomer = new Label("Customer: ");
    private final Label lblProduct = new Label("Product: ");
    private final Label lblShipping = new Label("Shipping Method: ");

    private ArrayList<Order> orders;

    public ResultPane(ArrayList<Order> orders) {
        this.orders = orders;
        add(lblOrder, 0, 0);
        add(lblCustomer, 1, 0);
        add(lblProduct, 2, 0);
        add(lblShipping, 3, 0);
        for (int i = 0; i < orders.size(); i++) {
            add(new Label(Integer.toString(orders.get(i).getOrderID())), 0, i + 1);
            add(new Label(Integer.toString(orders.get(i).getCustomerID())), 1, i + 1);
            add(new Label(orders.get(i).getProduct()), 2, i + 1);
            add(new Label(orders.get(i).getShipping()), 3, i + 1);
        }
        setAlignment(Pos.CENTER);
    }
}