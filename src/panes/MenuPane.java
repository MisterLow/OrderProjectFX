package panes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * Alexander Low
 * 991266865
 * Project
 * 2020/04/04
 */
public class MenuPane extends GridPane {

    private final Button btnAdd = new Button("Add");
    private final Button btnUpdate = new Button("Update");
    private final Button btnDelete;
    private final Button btnSave = new Button("Save");

    public MenuPane() {
        this.btnDelete = new Button("Delete");
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
