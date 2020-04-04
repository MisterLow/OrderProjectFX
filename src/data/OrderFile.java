package data;

import content.Order;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Iterator;

/**
 *
 * @author Alexander
 */
public class OrderFile {

    public static ArrayList<Order> loadOrders() throws FileNotFoundException, IOException {
        ArrayList<Order> orders = new ArrayList<>();
        FileReader fr = new FileReader("Order.dat");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        //if (line == null) {
        //    throw new IOException("File Cannot be Empty");
        //}
        while (line != null) {
            StringTokenizer st = new StringTokenizer(line, ",");
            int orderNum = Integer.parseInt(st.nextToken().trim().substring(1));
            int customerNum = Integer.parseInt(st.nextToken().trim().substring(1));
            Order order = new Order(orderNum);
            order.setCustomerID(customerNum);
            order.setProduct(st.nextToken().trim());
            order.setShipping(st.nextToken().trim());
            orders.add(order);
            line = br.readLine();
        }
        br.close();
        fr.close();
        return orders;
    }

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
