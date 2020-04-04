package orderprojectfx;

import content.Order;
import data.OrderFile;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
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
        Alert dlgError = new Alert(Alert.AlertType.ERROR);
        dlgError.setContentText("Numbers only");

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

        // Search
        search.getTxtCustomer().setOnKeyPressed(e -> {
            if (!isNumeric(e.getCode())) {
                dlgError.show();
            }
        });
        search.getBtnCustomer().setOnAction((e) -> {
        });
        search.getBtnProduct().setOnAction((e) -> {
        });

        // Main
        order.getTxtCustomer().setOnKeyPressed(e -> {
            if ((!isNumeric(e.getCode()) & order.getTxtCustomer().isEditable())) {
                dlgError.show();
            }
        });
        order.getTxtOrder().setOnKeyPressed(e -> {
            if ((!isNumeric(e.getCode()) & order.getTxtOrder().isEditable())) {
                dlgError.show();
            }
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

    private boolean isNumeric(KeyCode code) {
        return code.toString().startsWith("DIGIT");
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
