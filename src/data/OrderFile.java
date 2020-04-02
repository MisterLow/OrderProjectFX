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

/**
 *
 * @author Alexander
 */
public class OrderFile {

    public static ArrayList<Order> loadOrders() throws FileNotFoundException, IOException {
        ArrayList<Order> orders = new ArrayList<>();
        FileReader fr = new FileReader("./Order.dat");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            StringTokenizer st = new StringTokenizer(line, ",");
            int orderNum = Integer.parseInt(st.nextToken().substring(1));
            int customerNum = Integer.parseInt(st.nextToken().substring(1));
            Order order = new Order(orderNum);
            order.setCustomerID(customerNum);
            order.setProduct(st.nextToken());
            order.setShipping(st.nextToken());
            line = br.readLine();
        }
        br.close();
        fr.close();
        return orders;
    }

    public static void saveOrders(ArrayList<Order> orders) throws IOException {
        FileWriter fw = new FileWriter("./Order.dat", false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Order order : orders) {
            bw.write("O" + order.getOrderID() + ", C" + order.getCustomerID() + ", " + order.getShipping());
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
}
