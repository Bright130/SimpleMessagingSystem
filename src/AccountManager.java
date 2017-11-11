import java.util.ArrayList;
import java.util.Date;

public class AccountManager
{
    private static ArrayList<Account> accountsList;

    public static void initialize()
    {
        accountsList = new ArrayList<Account>();
        accountsList = DBConnection.getAccount();
    }

    public Account getAccount(String email)
    {
        Account account = null;
        for (Account a:accountsList)
        {
            if(email.equals(a.getEmail()))
            {
                account = a;
                break;
            }
        }
        return account;
    }
//
//    public ArrayList<Account> readAccount(String email)
//    {
//
//    }
//
//    public boolean writeAccount(Account account)
//    {
//
//    }
//
    public boolean login(String email,String password)
    {
        //Account account = new Account();
        for (Account a:accountsList)
        {
            if(email.equals(a.getEmail())&&password.equals(a.getPassword()))
            {
                return true;
            }
        }
        return false;
    }
//
//    public boolean logout(String email, Date upDateTime)
//    {
//
//    }

}
