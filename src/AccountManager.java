import java.util.ArrayList;
import java.util.Date;

public class AccountManager
{
    private  Account account = null;

    public  void initialize()
    {
       //  account = null;
       // accountsList = DBConnection.getAccount();
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
    public Account login(String email,String password)
    {
        Account temp=null;
        temp = DBConnection.getAccount(email) ;

            if(password.equals(temp.getPassword()))
            {
                account = temp;
                return account;
            }
        return null;
    }
//
//    public boolean logout(String email, Date upDateTime)
//    {
//
//    }
}
