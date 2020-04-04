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

    public void update(int currentOrder) {
        this.currentOrder = currentOrder;
        if (currentOrder == 0) {
            getBtnFirst().setVisible(false);
            getBtnPrev().setVisible(false);
        }else{
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
