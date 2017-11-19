import static java.lang.System.exit;

public class EmailClient
{
    private static Account account = new Account();

    private static AccountManager manager = new AccountManager();

    static public void main(String args[])
    {
        int number;
        int check = 0;

        manager.initialize();

        do
        {
            System.out.println("Simple Messaging System");
            System.out.println("    1. Login");
            System.out.println("    2. SignUp");
            System.out.println("    3. Exit");
            number = IOUtils.getInteger("Choose : ");

            switch (number)
            {
                case 1 :
                    System.out.println("Login");
                    Loginview loginview = new Loginview();
                    account = loginview.login(manager);
                    check=1;
                    break;

                case 2 :
                    System.out.println("SignUp");
                    SignUpView signUpView = new SignUpView();
                    account = signUpView.signUp(manager);
                    check=1;
                    break;

                case 3 :
                    System.out.println("Goodbye");
                    exit(0);
                    break;

                default: break;
            }
        } while (check ==0);

        DashBoard myDashBoard = new DashBoard(account);
        myDashBoard.showList();

    }
}
