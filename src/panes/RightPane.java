package panes;

import content.Order;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * Alexander Low
 * 991266865
 * Project
 * 2020/04/04
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
    }

    /**
     * Hide the pane
     */
    public void hide() {
        this.setVisible(false);
    }

    /**
     * Show the pane
     */
    public void show() {
        this.setVisible(true);
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
