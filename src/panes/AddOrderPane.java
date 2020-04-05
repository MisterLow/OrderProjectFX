package panes;

import content.Order;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Alexander Low
 * 991266865
 * Project
 * 2020/04/04
 */
public class AddOrderPane extends GridPane {

    private final Label lblOrder = new Label("Order: ");
    private final Label lblCustomer = new Label("Customer: ");
    private final Label lblProduct = new Label("Product: ");
    private final Label lblShipping = new Label("Shipping Method: ");

    private TextField txtOrder;
    private TextField txtCustomer;
    private TextField txtProduct;
    private TextField txtShipping;

    public AddOrderPane() {
        add(lblOrder, 0, 0);
        add(lblCustomer, 0, 1);
        add(lblProduct, 0, 2);
        add(lblShipping, 0, 3);

        add(txtOrder = new TextField(), 1, 0);
        add(txtCustomer = new TextField(), 1, 1);
        add(txtProduct = new TextField(), 1, 2);
        add(txtShipping = new TextField(), 1, 3);

        setAlignment(Pos.CENTER);
    }

    public void reset() {
        getTxtOrder().setText("");
        getTxtCustomer().setText("");
        getTxtProduct().setText("");
        getTxtShipping().setText("");
    }

    /**
     * @return the txtOrder
     */
    public TextField getTxtOrder() {
        return txtOrder;
    }

    /**
     * @return the txtCustomer
     */
    public TextField getTxtCustomer() {
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

    public Order generateOrder() throws Exception {
        if (getTxtOrder().getText().isEmpty()) {
            throw new Exception("Order cannot be empty");
        }
        if (getTxtCustomer().getText().isEmpty()) {
            throw new Exception("Customer cannot be empty");
        }
        if (getTxtProduct().getText().isEmpty()) {
            throw new Exception("Product cannot be empty");
        }
        if (getTxtShipping().getText().isEmpty()) {
            throw new Exception("Shipping cannot be empty");
        }

        Order order = new Order(Integer.parseInt(getTxtOrder().getText()));
        order.setCustomerID(Integer.parseInt(getTxtCustomer().getText()));
        order.setProduct(getTxtProduct().getText());
        order.setShipping(getTxtShipping().getText());

        return order;
    }
}
