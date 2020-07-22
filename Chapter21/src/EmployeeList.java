import java.sql.*;

public class EmployeeList {
    public static void main(String argv[]) {
        String sqlQuery = "SELECT * from Employee";


        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson21");
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery(sqlQuery);) {
            rs.afterLast();
            while (rs.previous()) {
                int empNo = rs.getInt("EMPNO");
                String eName = rs.getString("ENAME");
                String job = rs.getString("JOB_TITLE");
                System.out.println("" + empNo + ", " + eName + ", " + job);
            }
            }catch(SQLException se ){
                System.out.println("SQLError: " + se.getMessage()
                        + " code: " + se.getErrorCode());
            } catch(Exception e ){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }