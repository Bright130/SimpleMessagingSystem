

import java.sql.*;


public class DBConnection {

    public static void main(String[] args) {
        DBConnection.readDB("*","Account","1");


    }

    private static Connection openDB(){
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return connection ;
    }

    public static ResultSet readDB(String select,String from, String where) {

        Connection connection = openDB();
        if(connection == null)
            return null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = connection.createStatement();
//            String sql = "INSERT INTO t (num) " +
//                    "VALUES (1);";
//            stmt.executeUpdate(sql);

             rs = stmt.executeQuery( "SELECT "+select+" FROM "+from+" WHERE "+where+" ;");

            while ( rs.next() ) {
                //int id = rs.getInt("id");
                String  username = rs.getString("username");
                //int age  = rs.getInt("age");
                String  lastRefresh = rs.getString("lastRefresh");
                //float salary = rs.getFloat("salary");

                System.out.println( "Username = " + username );
                System.out.println( "Time = " + lastRefresh );

                System.out.println();
            }

            rs.close();
            stmt.close();
         //  connection.commit();
           connection.close();
           System.out.println("Records created successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }

       return rs;
    }
}
