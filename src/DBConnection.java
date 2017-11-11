/*********************************************
 *  DBConnection
 *   A class that connect to SQLite database
 *   to read and write data.
 *
 *   Created by Chainarong Tumapha (Bright) 58070503409
 *     11 November 2017
 *
 */


import java.sql.*;
import java.util.ArrayList;


public class DBConnection {

    /**  Tester  **/
    public static void main(String[] args) {
        ArrayList<Account> account =  DBConnection.getAccount();
        System.out.println(account.size());
        for (Account a:account) {
            System.out.println(a.getEmail());
            System.out.println(a.getPassword());
        }

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

    public static ArrayList<Account> getAccount(String where) {

        Connection connection = openDB();
        if(connection == null)
            return null;
        ArrayList<Account> accounts = new ArrayList<Account>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement();
//            String sql = "INSERT INTO t (num) " +
//                    "VALUES (1);";
//            statement.executeUpdate(sql);

            resultSet = statement.executeQuery( "SELECT * FROM Account WHERE "+where+" ;");

            while ( resultSet.next() ) {

                accounts.add(new Account(resultSet.getString("username"),
                        resultSet.getString("passwordUser"),
                        resultSet.getString("lastRefresh")
                ));
            }

            resultSet.close();
            statement.close();
            //  connection.commit();
            connection.close();
            System.out.println("Records created successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }

        return accounts;
    }

    public static ArrayList<Account> getAccount() {

        Connection connection = openDB();
        if(connection == null)
            return null;
        ArrayList<Account> accounts = new ArrayList<Account>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement();

            resultSet = statement.executeQuery( "SELECT * FROM Account  ;");

            while ( resultSet.next() ) {

                accounts.add(new Account(resultSet.getString("username"),
                        resultSet.getString("passwordUser"),
                        resultSet.getString("lastRefresh")
                ));
            }

            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Records created successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }

        return accounts;
    }


}
