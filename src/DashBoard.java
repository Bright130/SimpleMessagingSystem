import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.ArrayList;
import java.util.Scanner;

public class DashBoard
{
    private AccountManager manager;

    private ArrayList<EmailMessage> allMsg;

    private ArrayList<EmailMessage> readMsg;

    private ArrayList<EmailMessage> unReadMsg;

    private ArrayList<EmailMessage> sentMsg;

    private Account myAccount;

    private EmailMessage message;

    DashBoard(Account account)
    {
        allMsg = DBConnection.getMessage(account);
        this.myAccount = account;
    }

    public void readEmail()
    {
        allMsg = DBConnection.getMessage(myAccount);
    }

    public void menu()
    {

    }

    public void showDetail()
    {

    }

    public boolean deleteEmail()
    {
        return true;
    }

    public void showList()
    {
        int number;

        System.out.println("Hello  "+myAccount.getEmail());
        System.out.println("    1. Show all message");
        System.out.println("    2. Show new message");
        System.out.println("    3. Show read message");
        System.out.println("    4. Show all sent message");
        System.out.println("Choose : ");
        Scanner in = new Scanner(System.in);
        number = in.nextInt();

        switch (number)
        {
            case 1 :
                System.out.println("Show all message");
                for (EmailMessage m : allMsg)
                {
                    System.out.print("Subject = "+m.getSubject());
                    System.out.println("  From : "+m.getFromEmail());
                }
                break;

            case 2 :
                System.out.println("Show new message");
                break;

            default: break;
        }
    }
}
