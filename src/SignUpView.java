import java.util.Date;

public class SignUpView
{
    public Account signUp(AccountManager manager)
    {
        Account account;

        String userName;
        String password;
        String created;

        userName = IOUtils.getEmail();
        password = IOUtils.getPassword();
        created = IOUtils.getDateTime();

        account = new Account(userName,password,created);

        return account;
    }
}
