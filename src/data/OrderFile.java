package data;

import content.Order;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Iterator;

/**
 * Alexander Low 
 * 991266865 
 * Project 
 * 2020/04/04
 */
public class OrderFile {
    
    /**
     * Load all of the Orders from the file Order.dat
     *
     * @return An ArrayList of Order objects found in the file Order.dat
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception if the file isn't correctly formatted
     */
    public static ArrayList<Order> loadOrders() throws FileNotFoundException,
            IOException, Exception {
        ArrayList<Order> orders = new ArrayList<>();
        File file = new File("Order.dat");

        if (!file.exists()) {
            file.createNewFile();
            return orders;
        }
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String regex = "\\d+";
        String line = br.readLine();
        
        if (line == null) {
            br.close();
            fr.close();
            return orders;
        }

        while (line != null) {
            StringTokenizer st = new StringTokenizer(line, ",");
            String orderNum = st.nextToken().trim().substring(1);

            if (st.countTokens() < 3) {
                br.close();
                fr.close();
                throw new Exception("Formatting error in Order.dat");
            }

            if (!orderNum.matches(regex)) {
                br.close();
                fr.close();
                throw new Exception("Invalid Order Number");
            }
            int orderNumber = Integer.parseInt(orderNum);
            Order order = new Order(orderNumber);

            String customerNum = st.nextToken().trim().substring(1);
            if (!customerNum.matches(regex)) {
                br.close();
                fr.close();
                throw new Exception("Invalid Customer ID");
            }
            int customerNumber = Integer.parseInt(customerNum);
            order.setCustomerID(customerNumber);

            order.setProduct(st.nextToken().trim());
            order.setShipping(st.nextToken().trim());
            orders.add(order);
            line = br.readLine();
        }
        br.close();
        fr.close();
        return orders;
    }

    /**
     * Saves an ArrayList of Order objects to Order.dat in the following format:
     * o[orderID:int], c[customerID:int], [product:String], [shipping:String]
     *
     * @param orders an ArrayList of Order objects
     * @throws IOException
     */
    public static void saveOrders(ArrayList<Order> orders) throws IOException {
        FileWriter fw = new FileWriter("Order.dat", false);
        BufferedWriter bw = new BufferedWriter(fw);
        Iterator<Order> itOrder = orders.iterator();
        while (itOrder.hasNext()) {
            Order order = itOrder.next();
            bw.write("O" + order.getOrderID() + ", C" + order.getCustomerID()
                    + ", " + order.getProduct() + ", " + order.getShipping()
            );
            if (itOrder.hasNext()) {
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        fw.close();
    }
}
