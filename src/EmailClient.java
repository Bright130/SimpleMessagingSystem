public class EmailClient
{
    private static Account account = new Account();

    private static AccountManager manager = new AccountManager();

    static public void main(String args[])
    {
        String email;

        Loginview loginview = new Loginview();
        manager.initialize();
        email = loginview.login(manager);
        account = manager.getAccount(email);
        System.out.println(account.getEmail());
        System.out.println(account.getPassword());
    }
}
