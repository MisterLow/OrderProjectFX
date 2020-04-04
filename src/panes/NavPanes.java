package panes;

import content.Order;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alexander
 */
public class NavPanes{

    private final Button btnFirst = new Button("First");
    private final Button btnPrev = new Button("Previous");
    private final Button btnNext = new Button("Next");
    private final Button btnLast = new Button("Last");

    private GridPane leftPane = new GridPane();
    private GridPane rightPane = new GridPane();

    private ArrayList<Order> orders;
    private int currentOrder;

    public NavPanes(ArrayList<Order> orders) {
        this.orders = orders;
        leftPane.add(btnPrev, 0, 0);
        leftPane.add(btnFirst, 0, 1);
        rightPane.add(btnNext, 0, 0);
        rightPane.add(btnLast, 0, 1);
    }

    public GridPane getLeftPane() {
        return this.leftPane;
    }

    public GridPane getRightPane() {
        return this.rightPane;
    }

    public void prev() {
        
    }

    public void next() {

    }

    /**
     * Check if the next or previous button should be visible and then change
     * their visibility depending on if there is another student to view
     */
    private void buttonCheck() {
        if (getCurrentOrder() == 0) {
            getBtnPrev().setVisible(false);
        } else {
            getBtnPrev().setVisible(true);
            setCurrentOrder(getCurrentOrder() - 1);
        }
        if (getCurrentOrder() == orders.size() - 1) {
            getBtnNext().setVisible(false);
        } else {
            getBtnNext().setVisible(true);
            setCurrentOrder(getCurrentOrder() + 1);
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

    /**
     * @return the currentOrder
     */
    public int getCurrentOrder() {
        return currentOrder;
    }

    /**
     * @param currentOrder the currentOrder to set
     */
    public void setCurrentOrder(int currentOrder) {
        this.currentOrder = currentOrder;
    }
}
