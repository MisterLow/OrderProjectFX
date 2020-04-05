package panes;

import content.Order;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Alexander Low 991266865 Project 2020/04/04
 */
public class ResultPane extends GridPane {

    private final Label lblOrder = new Label("Orders");
    private final Label lblCustomer = new Label("Customers");
    private final Label lblProduct = new Label("Products");
    private final Label lblShipping = new Label("Shipping Methods");

    public ResultPane(ArrayList<Order> orders) {
        if (orders.isEmpty()) {
            add(new Label("No Matching Results"), 0, 0);
        } else {
            setUp(orders);
        }
        this.getStyleClass().add("result-pane");
        this.getStylesheets().add("/style/ResultStyle.css");
        this.setHgap(5);
        this.setVgap(5);
        setAlignment(Pos.CENTER);
    }

    private void setUp(ArrayList<Order> orders) {
        add(lblOrder, 0, 0);
        add(lblCustomer, 1, 0);
        add(lblProduct, 2, 0);
        add(lblShipping, 3, 0);
        lblOrder.getStyleClass().add("titles");
        lblCustomer.getStyleClass().add("titles");
        lblProduct.getStyleClass().add("titles");
        lblShipping.getStyleClass().add("titles");
        for (int i = 0; i < orders.size(); i++) {
            add(new Label(
                    Integer.toString(orders.get(i).getOrderID())), 0, i + 1);
            add(new Label(
                    Integer.toString(orders.get(i).getCustomerID())), 1, i + 1);
            add(new Label(orders.get(i).getProduct()), 2, i + 1);
            add(new Label(orders.get(i).getShipping()), 3, i + 1);
        }
    }
}
