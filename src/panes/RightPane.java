package panes;

import content.Order;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alexander
 */
public class RightPane extends GridPane {

    private final Button btnNext = new Button("Next");
    private final Button btnLast = new Button("Last");
    private ArrayList<Order> orders;
    private int currentOrder = 0;

    public RightPane(ArrayList<Order> orders, int currentOrder) {
        this.orders = orders;
        add(btnNext, 0, 0);
        add(btnLast, 0, 1);
        setAlignment(Pos.CENTER);
        update(currentOrder);
    }

    public void update(int currentOrder) {
        this.currentOrder = currentOrder;
        if (currentOrder == orders.size() - 1) {
            getBtnLast().setVisible(false);
            getBtnNext().setVisible(false);
        } else {

            getBtnLast().setVisible(true);
            getBtnNext().setVisible(true);
        }
    }

    /**
     * @return the btnNext
     */
    public Button getBtnNext() {
        return btnNext;
    }

    /**
     * @return the btnLast
     */
    public Button getBtnLast() {
        return btnLast;
    }
}
