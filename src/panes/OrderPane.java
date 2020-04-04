package panes;

import orderprojectfx.NumField;
import content.Order;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alexander
 */
public class OrderPane extends GridPane {

    private final Label lblOrder = new Label("Order: ");
    private final Label lblCustomer = new Label("Customer: ");
    private final Label lblProduct = new Label("Product: ");
    private final Label lblShipping = new Label("Shipping Method: ");

    private NumField txtOrder = new NumField();
    private NumField txtCustomer = new NumField();
    private TextField txtProduct = new TextField();
    private TextField txtShipping = new TextField();

    private ArrayList<Order> orders;
    private int currentOrder;

    public OrderPane(ArrayList<Order> orders, int currentOrder) {
        this.orders = orders;
        add(lblOrder, 0, 0);
        add(lblCustomer, 0, 1);
        add(lblProduct, 0, 2);
        add(lblShipping, 0, 3);
        
        add(txtOrder, 1, 0);
        txtOrder.setEditable(false);
        add(txtCustomer, 1, 1);
        txtCustomer.setEditable(false);
        add(txtProduct, 1, 2);
        txtProduct.redoableProperty();
        add(txtShipping, 1, 3);
        setAlignment(Pos.CENTER);
        update(currentOrder);
    }
    
    public void add() {
        //getTxtOrder().setText();
        getTxtCustomer().setText(Integer.toString(orders.get(currentOrder).getCustomerID()));
        getTxtProduct().setText(orders.get(currentOrder).getProduct());
        getTxtShipping().setText(orders.get(currentOrder).getShipping());
    }
    
    public void update(int currentOrder) {
        this.currentOrder = currentOrder;
        getTxtOrder().setNum(orders.get(currentOrder).getOrderID());
        getTxtCustomer().setNum(orders.get(currentOrder).getCustomerID());
        getTxtProduct().setText(orders.get(currentOrder).getProduct());
        getTxtShipping().setText(orders.get(currentOrder).getShipping());
    }

    /**
     * @return the txtOrder
     */
    public NumField getTxtOrder() {
        return txtOrder;
    }

    /**
     * @return the txtCustomer
     */
    public NumField getTxtCustomer() {
        return txtCustomer;
    }

    /**
     * @return the txtProduct
     */
    public TextField getTxtProduct() {
        return txtProduct;
    }

    /**
     * @return the txtShipping
     */
    public TextField getTxtShipping() {
        return txtShipping;
    }
}
