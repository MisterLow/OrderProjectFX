package orderprojectfx;

import content.Order;
import data.OrderFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Alexander
 */
public class OrderProjectFXMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            ArrayList<Order> orders = OrderFile.loadOrders();
        } catch (IOException ex) {
            Logger.getLogger(OrderProjectFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        primaryStage.setTitle("Hello World!");

        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
