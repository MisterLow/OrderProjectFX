package stages;

import content.Order;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Alexander
 */
public class SearchResultStage extends Stage {

    public SearchResultStage(ArrayList<Order> orders) {
        setScene(addScene());
    }

    public SearchResultStage(ArrayList<Order> orders, int ID) {
        setScene(addScene());
    }

    public SearchResultStage(ArrayList<Order> orders, String product) {
        setScene(addScene());
    }

    private Scene addScene() {
        BorderPane pane = new BorderPane();

        return new Scene(pane, 400, 400);
    }
}
