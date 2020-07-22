package tryit;

import java.sql.*;

public class Portfolio  implements Runnable{
    public void run(){
        String sqlQuery = "SELECT * from Portfolio";


        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson21");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQuery);) {

            while (rs.next()) {
                String symbol = rs.getString(2);
                Integer quantity = rs.getInt(3);
                Float price = rs.getFloat(4);

                StringBuilder builder = new StringBuilder();
                builder.append("Symbol: ");
                builder.append(symbol);
                builder.append(", quantity: ");
                builder.append(quantity);
                builder.append(", total shares: ");
                builder.append(quantity * price);
                System.out.println(builder.toString());
            }
        }catch(SQLException se ){
            System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
        } catch(Exception e ){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
