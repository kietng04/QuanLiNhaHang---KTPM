package BUS;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDB {
    
    public static Connection openConnect() throws Exception{

        String connectionUrl = "jdbc:postgresql://dpg-co1flb6ct0pc73dbnh5g-a.singapore-postgres.render.com:5432/restaurant_management_a76y?ssl=true&user=nam&password=ii7c7AQD68CDzEpUgfU7rERpBfReKfHs";
        Connection con = DriverManager.getConnection(connectionUrl);
        return con;
    }
}
