public class Loginview
{
    public Account login(AccountManager manager)
    {
        Account account;
        String email;
        String password;

        email = IOUtils.getEmail();
        password = IOUtils.getPassword();

        return account;
    }
}
