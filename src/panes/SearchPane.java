package panes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Alexander Low
 * 991266865
 * Project
 * 2020/04/04
 */
public class SearchPane extends GridPane {

    private Label lblCustomer = new Label("Customer Search: ");
    private TextField txtCustomer = new TextField();
    private Label lblProduct = new Label("Product Search: ");
    private TextField txtProduct = new TextField();
    private final Button btnSearch = new Button("Search");
    private final Button btnView = new Button("View All");

    public SearchPane() {
        add(lblCustomer, 0, 0);
        add(txtCustomer, 1, 0);
        add(btnSearch, 2, 0, 1, 2);
        add(lblProduct, 0, 1);
        add(txtProduct, 1, 1);
        add(btnView, 3, 0, 1, 2);
        setAlignment(Pos.CENTER);
    }

    /**
     * @return the txtCustomer
     */
    public TextField getTxtCustomer() {
        return txtCustomer;
    }

    /**
     * @return the txtProduct
     */
    public TextField getTxtProduct() {
        return txtProduct;
    }

    /**
     * @return the btnSearch
     */
    public Button getBtnSearch() {
        return btnSearch;
    }

    /**
     * @return the btnView
     */
    public Button getBtnView() {
        return btnView;
    }

}
