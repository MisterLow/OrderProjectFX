package orderprojectfx;

import content.Order;
import data.OrderFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import panes.*;
import stages.SearchResultStage;

/**
 * Alexander Low 
 * 991266865 
 * Project 
 * 2020/04/04
 */
public class OrderProjectFXMain extends Application {

    private ArrayList<Order> orders;
    private int currentOrder = 0;

    private SearchPane pnSearch;
    private LeftPane pnLeft;
    private RightPane pnRight;
    private OrderPane pnOrder;
    private MenuPane pnMenu;
    private AddMenuPane pnAddMenu;
    private BorderPane pane;

    @Override
    public void start(Stage primaryStage) {
        // Setup
        try {
            orders = OrderFile.loadOrders();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        paneSetup();

        Alert dlgInputMismatch = new Alert(Alert.AlertType.ERROR);
        dlgInputMismatch.setHeaderText("Input Error");
        dlgInputMismatch.setContentText("Numbers only");

        Alert dlgEmpty = new Alert(Alert.AlertType.ERROR);
        dlgEmpty.setHeaderText("Input Error");
        dlgEmpty.setContentText("Search cannot be blank");

        Alert dlgOrderEmpty = new Alert(Alert.AlertType.ERROR);
        dlgOrderEmpty.setHeaderText("Input Error");
        dlgOrderEmpty.setContentText("Order fields cannot be blank");

        // Navigation
        pnLeft.getBtnFirst().setOnAction((e) -> {
            currentOrder = 0;
            updateViews();
        });
        pnLeft.getBtnPrev().setOnAction((e) -> {
            currentOrder--;
            updateViews();

        });
        pnRight.getBtnLast().setOnAction((e) -> {
            currentOrder = orders.size() - 1;
            updateViews();

        });
        pnRight.getBtnNext().setOnAction((e) -> {
            currentOrder++;
            updateViews();
        });

        // Search
        pnSearch.getTxtCustomer().setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER") && !(pnSearch.getTxtCustomer().getText().isEmpty())) {
                SearchResultStage searchStage = new SearchResultStage(orders,
                        Integer.parseInt(pnSearch.getTxtCustomer().getText()));
                searchStage.show();
            } else if (e.getCode().toString().equals("ENTER")) {
                dlgEmpty.setContentText("Search cannot be blank");
                dlgEmpty.show();
            } else if (!isNumeric(e.getCode())) {
                dlgInputMismatch.show();
            }
        });
        pnSearch.getTxtProduct().setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")
                    && !(pnSearch.getTxtCustomer().getText().isEmpty())) {
                SearchResultStage searchStage = new SearchResultStage(
                        orders, pnSearch.getTxtProduct().getText());
                searchStage.show();
            } else if (e.getCode().toString().equals("ENTER")) {
                dlgEmpty.setContentText("Search cannot be blank");
                dlgEmpty.show();
            }
        });
        pnSearch.getBtnSearch().setOnAction((e) -> {
            if (!(pnSearch.getTxtCustomer().getText().isEmpty())) {
                SearchResultStage searchStage = new SearchResultStage(orders,
                        Integer.parseInt(pnSearch.getTxtCustomer().getText()));
                searchStage.show();
            } else if (!pnSearch.getTxtProduct().getText().isEmpty()) {
                SearchResultStage searchStage = new SearchResultStage(
                        orders, pnSearch.getTxtProduct().getText());
                searchStage.show();
            }
        });
        pnSearch.getBtnView().setOnAction((e) -> {
            SearchResultStage resultStage = new SearchResultStage(orders);
            resultStage.show();
        });

        // Main
        pnOrder.getTxtCustomer().setOnKeyPressed(e -> {
            if ((!isNumeric(e.getCode())
                    & pnOrder.getTxtCustomer().isEditable())) {
                dlgInputMismatch.show();
            }
        });
        pnOrder.getTxtOrder().setOnKeyPressed(e -> {
            if ((!isNumeric(e.getCode())
                    & pnOrder.getTxtOrder().isEditable())) {
                dlgInputMismatch.show();
            }
        });

        // Menu Items
        pnMenu.getBtnAdd().setOnAction((e) -> {
            newOrderView(true);
        });
        pnMenu.getBtnUpdate().setOnAction((e) -> {
            Alert dlgConfirmation = new Alert(AlertType.CONFIRMATION);
            dlgConfirmation.setHeaderText("Update Confimation");
            dlgConfirmation.setContentText(
                    "Are you sure you want to update this order?");
            Optional<ButtonType> result = dlgConfirmation.showAndWait();
            if (result.get() == ButtonType.OK) {
                orders.get(currentOrder).setProduct(
                        pnOrder.getTxtProduct().getText());
                orders.get(currentOrder).setShipping(
                        pnOrder.getTxtShipping().getText());
            } else {
                pnOrder.update(currentOrder);
            }

            updateViews();
        });
        pnMenu.getBtnDelete().setOnAction((e) -> {
            Alert dlgConfirmation = new Alert(AlertType.CONFIRMATION);
            dlgConfirmation.setHeaderText("Delete Confimation");
            dlgConfirmation.setContentText(
                    "Are you sure you want to delete this order?");
            Optional<ButtonType> result = dlgConfirmation.showAndWait();
            if (result.get() == ButtonType.OK) {
                orders.remove(currentOrder);
                updateViews();
            }
        });
        pnMenu.getBtnSave().setOnAction((e) -> {
            try {
                OrderFile.saveOrders(orders);
            } catch (IOException ex) {
                System.err.println("Save error");
            }
        });

        // Menu Options for adding a new Order
        pnAddMenu.getBtnAdd().setOnAction((e) -> {
            boolean completedForm = true;
            if (pnOrder.getTxtOrder().getText().isEmpty()) {
                completedForm = false;
                pnOrder.getTxtOrder().requestFocus();
            } else if (pnOrder.getTxtCustomer().getText().isEmpty()) {
                completedForm = false;
                pnOrder.getTxtCustomer().requestFocus();
            } else if (pnOrder.getTxtProduct().getText().isEmpty()) {
                completedForm = false;
                pnOrder.getTxtProduct().requestFocus();
            } else if (pnOrder.getTxtShipping().getText().isEmpty()) {
                completedForm = false;
                pnOrder.getTxtShipping().requestFocus();
            }
            if (!completedForm) {
                dlgOrderEmpty.show();
            } else {
                try {
                    orders.add(pnOrder.generateOrder());
                } catch (Exception ex) {
                    System.err.println(ex);
                }
                newOrderView(false);
            }
        });
        pnAddMenu.getBtnCancel().setOnAction((e) -> {
            newOrderView(false);
        });

        Scene scene = new Scene(pane, 400, 300);

        primaryStage.setTitle("Order Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        try {
            OrderFile.saveOrders(orders);
        } catch (IOException ex) {
            System.err.println("Save error");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void paneSetup() {
        pnMenu = new MenuPane();
        pnAddMenu = new AddMenuPane();
        pnLeft = new LeftPane(orders, currentOrder);
        pnOrder = new OrderPane(orders, currentOrder);
        pnRight = new RightPane(orders, currentOrder);
        pane = new BorderPane();
        pnSearch = new SearchPane();
        pane.setTop(pnSearch);
        pane.setLeft(pnLeft);
        pane.setCenter(pnOrder);
        pane.setRight(pnRight);
        pane.setBottom(pnMenu);
        updateViews();
    }

    /**
     * Checks if a code is a number, but will also allow back space to be
     * pressed
     *
     * @param code
     * @return true if the Value is a number or back space character
     */
    private boolean isNumeric(KeyCode code) {
        return (code.toString().startsWith("DIGIT"))
                || (code.toString().startsWith("NUMPAD"))
                || (code.toString().equals("BACK_SPACE"));
    }

    /**
     * Switch between the regular view and adding a new order
     *
     * @param on
     */
    private void newOrderView(boolean on) {
        if (on) {
            pnOrder.addOrderView();
            pane.setBottom(pnAddMenu);
            pnLeft.hide();
            pnRight.hide();
            pnOrder.getTxtOrder().requestFocus();
        } else {
            pnOrder.orderView();
            pane.setBottom(pnMenu);
            pnLeft.show();
            pnRight.show();
        }
        updateViews();
    }

    /**
     * Update all views that can change to display the correct information for
     * the current order
     */
    private void updateViews() {
        if (currentOrder > orders.size() - 1) {
            currentOrder--;
        } else if (currentOrder < 0) {
            currentOrder++;
        }
        pnLeft.update(currentOrder);
        pnOrder.update(currentOrder);
        pnRight.update(currentOrder);
    }
}
