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
    private final Button btnCancel = new Button("Cancel");
    private final Button btnUpdate = new Button("Update");
    private final Button btnDelete = new Button("Delete");
    private final Button btnSave = new Button("Save");

    private boolean addView = false;

    public MenuPane() {
        add(btnAdd, 1, 0);
        add(btnCancel, 0, 0);
        add(btnUpdate, 2, 0);
        add(btnDelete, 3, 0);
        add(btnSave, 4, 0);
        setAlignment(Pos.CENTER);
    }

    public void addOrderView() {
        btnUpdate.setVisible(addView);
        btnDelete.setVisible(addView);
        btnSave.setVisible(addView);
        addView = true;
        btnCancel.setVisible(addView);
    }

    public void orderView() {
        btnUpdate.setVisible(addView);
        btnDelete.setVisible(addView);
        btnSave.setVisible(addView);
        addView = false;
        btnCancel.setVisible(addView);
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

    /**
     * @return the addView
     */
    public boolean isAddView() {
        return addView;
    }
}
