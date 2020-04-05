package panes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alexander
 */
public class AddMenuPane extends GridPane {

    private Button btnAdd = new Button("Add");
    private Button btnCancel = new Button("Cancel");

    public AddMenuPane() {
        add(btnAdd, 0, 0);
        add(btnCancel, 1, 0);
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

    /**
     * @return the btnAdd
     */
    public Button getBtnAdd() {
        return btnAdd;
    }

    /**
     * @return the btnUpdate
     */
    public Button getBtnCancel() {
        return btnCancel;
    }

}
