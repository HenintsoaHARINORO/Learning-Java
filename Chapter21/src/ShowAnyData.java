import java.sql.*;

public class ShowAnyData {
    public static void main(String [] args){
        if(args.length== 0){
            System.out.println("Usage: java ShowANyData SQLSelectStatement");
            System.out.println("For example: java ShowAnyData \"Select * from Employee\"");
            System.exit(1);
        }
        try(Connection conn= DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson21");
            Statement stmt= conn.createStatement();
            ResultSet rs= stmt.executeQuery(args[0]);){
            ResultSetMetaData rsMeta = rs.getMetaData();
            int colCount = rsMeta.getColumnCount();
            for (int i= 1;i <= colCount; i+= 1){
                System.out.println(rsMeta.getColumnName(i)+ " ");
            }
            System.out.println();

            while (rs.next()){
                for (int i= 1; i<= colCount; i+=1){
                    System.out.println(rs.getString(i)+" ");
                }
                System.out.println("\n");
            }
        }catch (SQLException se){
            System.out.println("SQLErros: "+ se.getMessage()+ "code: "+ se.getErrorCode());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
