public class EmailClient
{
    private static Account account = new Account();

    private static AccountManager manager = new AccountManager();

    static public void main(String args[])
    {
        Loginview loginview = new Loginview();
        manager.initialize();
        account = loginview.login(manager);
        System.out.println(account.getEmail());
        System.out.println(account.getPassword());
    }
}
