package orderprojectfx;

import content.Order;
import data.OrderFile;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import panes.LeftPane;
import panes.RightPane;

/**
 *
 * @author Alexander
 */
public class OrderProjectFXMain extends Application {

    private ArrayList<Order> orders;
    private int currentOrder = 0;

    private LeftPane left;
    private RightPane right;
    private BorderPane pane;

    @Override
    public void start(Stage primaryStage) {
        try {
            orders = OrderFile.loadOrders();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        paneSetup();

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
        Scene scene = new Scene(pane, 400, 400);

        primaryStage.setTitle("View Orders");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void paneSetup() {
        left = new LeftPane(orders, currentOrder);
        right = new RightPane(orders, currentOrder);
        pane = new BorderPane();
        pane.setLeft(left);
        pane.setRight(right);
        updateViews();
    }

    private void updateViews() {
        left.update(currentOrder);
        right.update(currentOrder);
    }
}
