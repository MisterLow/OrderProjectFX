package stages;

import content.Order;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import panes.ResultPane;

/**
 * Alexander Low
 * 991266865
 * Project
 * 2020/04/04
 */
public class SearchResultStage extends Stage {

    private final int ID;
    private final String product;
    private final String title;
    ArrayList<Order> orders;

    public SearchResultStage(ArrayList<Order> orders) {
        this(orders, -1, null, "All Orders");
    }

    public SearchResultStage(ArrayList<Order> orders, int ID) {
        this(orders, ID, null, "Matching Customer Results");
    }

    public SearchResultStage(ArrayList<Order> orders, String product) {
        this(orders, -1, product, "Matching Product Results");
    }

    public SearchResultStage(ArrayList<Order> orders, int ID, String product, String title) {
        this.orders = orders;
        this.ID = ID;
        this.product = product;
        this.title = title;
        setScene(addScene());
    }

    private Scene addScene() {
        ArrayList<Order> orderResults = new ArrayList<>();

        if (ID >= 0) {
            for (Order order : orders) {
                if (order.getCustomerID() == ID) {
                    orderResults.add(order);
                }
            }
        } else if (product != null) {
            for (Order order : orders) {
                if (order.getProduct().equalsIgnoreCase(product)) {
                    orderResults.add(order);
                }
            }

        } else {
            orderResults = orders;
        }

        ResultPane pane = new ResultPane(orderResults);
        Scene scene = new Scene(pane, 350, (100 + (orderResults.size() * 25)));
        this.setTitle(title);
        return scene;
    }
}
