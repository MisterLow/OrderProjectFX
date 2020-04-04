package orderprojectfx;

import content.Order;
import data.OrderFile;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import panes.*;

/**
 *
 * @author Alexander
 */
public class OrderProjectFXMain extends Application {

    private ArrayList<Order> orders;
    private int currentOrder = 0;

    private SearchPane search;
    private LeftPane left;
    private RightPane right;
    private MenuPane menu;
    private OrderPane order;
    private BorderPane pane;

    @Override
    public void start(Stage primaryStage) {
        // Setup
        try {
            orders = OrderFile.loadOrders();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        paneSetup();

        // Navigation
        left.getBtnFirst().setOnAction((e) -> {
            currentOrder = 0;
            updateViews();

        });
        left.getBtnPrev().setOnAction((e) -> {
            currentOrder--;
            updateViews();

        });
        right.getBtnLast().setOnAction((e) -> {
            currentOrder = orders.size() - 1;
            updateViews();

        });
        right.getBtnNext().setOnAction((e) -> {
            currentOrder++;
            updateViews();
        });

        // Prevent the user from altering the cusomer and order IDs
        order.getTxtOrder().setOnKeyReleased(e -> {
            order.getTxtOrder().setText(Integer.toString(orders.get(currentOrder).getOrderID()));
        });
        order.getTxtCustomer().setOnKeyReleased(e -> {
            order.getTxtCustomer().setText(Integer.toString(orders.get(currentOrder).getCustomerID()));
        });

        // Menu Items
        menu.getBtnUpdate().setOnAction((e) -> {
            orders.get(currentOrder).setProduct(order.getTxtProduct().getText());
            orders.get(currentOrder).setShipping(order.getTxtShipping().getText());
            updateViews();
        });
        menu.getBtnDelete().setOnAction((e) -> {
            orders.remove(currentOrder);
            updateViews();
        });
        menu.getBtnSave().setOnAction((e) -> {
            try {
                OrderFile.saveOrders(orders);
            } catch (IOException ex) {
                System.err.println("Save error");
            }
        });

        Scene scene = new Scene(pane, 400, 300);

        primaryStage.setTitle("Order Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        try {
            OrderFile.saveOrders(orders);
        } catch (IOException ex) {
            System.err.println("Save error");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void paneSetup() {
        menu = new MenuPane();
        left = new LeftPane(orders, currentOrder);
        order = new OrderPane(orders, currentOrder);
        right = new RightPane(orders, currentOrder);
        pane = new BorderPane();
        search = new SearchPane();
        pane.setTop(search);
        pane.setLeft(left);
        pane.setCenter(order);
        pane.setRight(right);
        pane.setBottom(menu);
        updateViews();
    }

    /**
     * Update all views that can change
     */
    private void updateViews() {
        left.update(currentOrder);
        order.update(currentOrder);
        right.update(currentOrder);
    }
}
