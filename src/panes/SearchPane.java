package panes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alexander
 */
public class SearchPane extends GridPane {

    private Label lblCustomer = new Label("Customer Search: ");
    private TextField txtCustomer = new TextField();
    private final Button btnCustomer = new Button("Search");
    private Label lblProduct = new Label("Product Search: ");
    private TextField txtProduct = new TextField();
    private final Button btnProduct = new Button("Search");

    public SearchPane() {
        add(lblCustomer, 0, 0);
        add(txtCustomer, 1, 0);
        add(btnCustomer, 2, 0);
        add(lblProduct, 0, 1);
        add(txtProduct, 1, 1);
        add(btnProduct, 2, 1);
        setAlignment(Pos.CENTER);
    }

    /**
     * @return the txtCustomer
     */
    public TextField getTxtCustomer() {
        return txtCustomer;
    }

    /**
     * @return the btnCustomer
     */
    public Button getBtnCustomer() {
        return btnCustomer;
    }

    /**
     * @return the txtProduct
     */
    public TextField getTxtProduct() {
        return txtProduct;
    }

    /**
     * @return the btnProduct
     */
    public Button getBtnProduct() {
        return btnProduct;
    }
}
