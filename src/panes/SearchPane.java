package panes;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alexander
 */
public class SearchPane extends GridPane {

    private Label lblSearch = new Label("Customer Search: ");
    private TextField txtSearch = new TextField();

    public SearchPane() {
        add(lblSearch, 0, 0);
        add(txtSearch, 1, 0);
        setAlignment(Pos.CENTER);
    }
}
