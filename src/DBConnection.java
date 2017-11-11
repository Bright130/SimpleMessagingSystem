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
        boolean a =DBConnection.deleteAccount(new Account ("aaa@a.com","000","2013-01-22 12:12:12"));

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

    public static Account getAccount(String email) {

        Connection connection = openDB();
        if(connection == null)
            return null;
        Account account = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement();

            resultSet = statement.executeQuery( "SELECT * FROM Account WHERE username like '"+email+"' ;");

            if ( resultSet.next()) {

                account =  new Account(resultSet.getString("username"),
                                   resultSet.getString("passwordUser"),
                                   resultSet.getString("lastRefresh")
                                  );
            }

            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Read successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }
        return account;
    }

    public static boolean createAccount(Account account) {

        Connection connection = openDB();
        if(connection == null)
            return false;
        Statement statement = null;

        try{
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Account (username,passwordUser,lastRefresh) " +
                                        "VALUES  ('"+account.getEmail()+"'" +
                                                ",'"+account.getPassword()+"'" +
                                                ",'"+account.getLastUpdate()+"');"
                                    );

            statement.close();
            connection.commit();
            connection.close();
            System.out.println("Insert successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return false;
        }
        return true;
    }

    public static boolean updateAccount(Account account) {

        Connection connection = openDB();
        if(connection == null)
            return false;
        Statement statement = null;

        try{
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE Account set "+
                                        "passwordUser = '"+account.getPassword()+"',"+
                                        "lastRefresh = '"+account.getLastUpdate()+"' "+
                                        "WHERE username like '"+account.getEmail()+"' "+
                                        " ;"
            );

            statement.close();
            connection.commit();
            connection.close();
            System.out.println("Update successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return false;
        }
        return true;
    }

    public static boolean deleteAccount(Account account) {

        Connection connection = openDB();
        if(connection == null)
            return false;
        Statement statement = null;

        try{

            statement = connection.createStatement();
            statement.executeUpdate("DELETE from Account "+
                    "WHERE username like '"+account.getEmail()+"' "+
                    " ;"
            );

            statement.close();
            connection.commit();
            connection.close();
            System.out.println("Delete successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return false;
        }
        return true;
    }


//    public static ArrayList<Account> getAccounts() {
//
//        Connection connection = openDB();
//        if(connection == null)
//            return null;
//        ArrayList<Account> accounts = new ArrayList<Account>();
//        Statement statement = null;
//        ResultSet resultSet = null;
//        try{
//            statement = connection.createStatement();
//
//            resultSet = statement.executeQuery( "SELECT * FROM Account  ;");
//
//            while ( resultSet.next() ) {
//
//                accounts.add(new Account(resultSet.getString("username"),
//                        resultSet.getString("passwordUser"),
//                        resultSet.getString("lastRefresh")
//                ));
//            }
//
//            resultSet.close();
//            statement.close();
//            connection.close();
//            System.out.println("Records created successfully");
//        } catch ( Exception e ) {
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//
//        }
//        return accounts;
//    }






}
