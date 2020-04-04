package stages;

import content.Order;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import panes.ResultPane;

/**
 *
 * @author Alexander
 */
public class SearchResultStage extends Stage {

    private final int ID;
    private final String product;
    ArrayList<Order> orders;

    public SearchResultStage(ArrayList<Order> orders) {
        this(orders, -1, null);
    }

    public SearchResultStage(ArrayList<Order> orders, int ID) {
        this(orders, ID, null);
    }

    public SearchResultStage(ArrayList<Order> orders, String product) {
        this(orders, -1, product);
    }

    public SearchResultStage(ArrayList<Order> orders, int ID, String product) {
        this.orders = orders;
        this.ID = ID;
        this.product = product;
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

        return new Scene(pane, 300, 300);
    }
}
