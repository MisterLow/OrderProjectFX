package panes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alexander
 */
public class MenuPane extends GridPane {

    private Button btnAdd = new Button("Add");
    private Button btnUpdate = new Button("Update");
    private Button btnDelete = new Button("Delete");
    private Button btnSave = new Button("Save");

    public MenuPane() {
        add(btnAdd, 0, 0);
        add(btnUpdate, 1, 0);
        add(btnDelete, 2, 0);
        add(btnSave, 3, 0);
        setAlignment(Pos.CENTER);
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
    public Button getBtnUpdate() {
        return btnUpdate;
    }

    /**
     * @return the btnDelete
     */
    public Button getBtnDelete() {
        return btnDelete;
    }

    /**
     * @return the btnSave
     */
    public Button getBtnSave() {
        return btnSave;
    }
}
