package panes;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alexander
 */
public class SearchPane extends GridPane {

    private TextField txtSearch = new TextField();

    public SearchPane() {
        add(txtSearch, 0, 0);
    }
}
