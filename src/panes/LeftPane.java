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
public class LeftPane extends GridPane {

    private final Button btnFirst = new Button("First");
    private final Button btnPrev = new Button("Previous");

    private ArrayList<Order> orders;
    private int currentOrder;

    public LeftPane(ArrayList<Order> orders, int currentOrder) {
        this.orders = orders;
        add(btnPrev, 0, 0);
        add(btnFirst, 0, 1);
        setAlignment(Pos.CENTER);
        update(currentOrder);
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
        if (currentOrder == 0) {
            getBtnFirst().setVisible(false);
            getBtnPrev().setVisible(false);
        } else {
            getBtnFirst().setVisible(true);
            getBtnPrev().setVisible(true);
        }
    }

    /**
     * @return the btnFirst
     */
    public Button getBtnFirst() {
        return btnFirst;
    }

    /**
     * @return the btnPrev
     */
    public Button getBtnPrev() {
        return btnPrev;
    }
}
