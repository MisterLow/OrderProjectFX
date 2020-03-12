package content;

/**
 *
 * @author Alexander
 */
public class Order {

    private int orderID, customerID;
    private String product, shipping;

    public Order(int orderID) {
        setOrderID(orderID);
    }

    /**
     * @return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @return the shipping
     */
    public String getShipping() {
        return shipping;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * @param shipping the shipping to set
     */
    public void setShipping(String shipping) {
        this.shipping = shipping;
    }
}
