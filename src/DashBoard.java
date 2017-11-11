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
        this.myAccount = account;
    }

    public void readEmail()
    {
        allMsg = DBConnection.getMessage(myAccount);
        readMsg = new ArrayList<EmailMessage>();
        unReadMsg = new ArrayList<EmailMessage>();
        sentMsg = new ArrayList<EmailMessage>();

        for (EmailMessage m : allMsg)
        {
            if(m.getIsRead()==1&&myAccount.getEmail().equals(m.getToEmail()))
            {
                unReadMsg.add(m);
            }
            else if(m.getIsRead()==0&&myAccount.getEmail().equals(m.getToEmail()))
            {
                readMsg.add(m);
            }
            else if(myAccount.getEmail().equals(m.getFromEmail()))
            {
                sentMsg.add(m);
            }
        }
    }

    public void menu(ArrayList<EmailMessage> emailList)
    {
        EmailMessage temp = null;
        int number;
        Scanner in = new Scanner(System.in);

        System.out.println("Select an email : ");
        number = in.nextInt();
        temp = emailList.get(number-1);

        System.out.println("Subject :  "+temp.getSubject());
        System.out.println("    1. Read     2. Forward      3. Reply    4. Remove");
        System.out.println("Choose : ");
        number = in.nextInt();
        switch (number)
        {
            case 1 :
                System.out.println("Read");
                showDetail(temp);
                break;
            case 2 :
                System.out.println("Forward");
                break;
            case 3 :
                System.out.println("Reply");
                break;
            case 4 :
                System.out.println("Remove");
                break;
            case 5 :
                System.out.println("Exit");
                break;

            default: break;
        }
    }

    public void showDetail(EmailMessage email)
    {
        System.out.println("Subject : "+email.getSubject());
        System.out.println("From : "+email.getFromEmail());
        System.out.println("To : "+email.getToEmail());
        System.out.println(""+email.getLastModified());
        System.out.println("\n\n"+email.getBodyText()+"\n\n");

        email.setIsRead(0);
        DBConnection.updateStatusMessage(email);
    }

    public boolean deleteEmail()
    {
        return true;
    }

    public void showList()
    {

        readEmail();
        int number;
        int i=1;

        do
        {
            System.out.println("Hello  "+myAccount.getEmail());
            System.out.println("    1. Show all message         "+allMsg.size());
            System.out.println("    2. Show new message         "+unReadMsg.size());
            System.out.println("    3. Show read message        "+readMsg.size());
            System.out.println("    4. Show all sent message    "+sentMsg.size());
            System.out.println("    5. Log out    ");
            System.out.println("Choose : ");
            Scanner in = new Scanner(System.in);
            number = in.nextInt();
            switch (number)
            {
                case 1 :
                    System.out.println("Show all message");
                    for (EmailMessage m : allMsg)
                    {
                        System.out.print(""+(i++)+". Subject : "+m.getSubject());
                        System.out.print("          From : "+m.getFromEmail());
                        System.out.println("    "+m.getLastModified());
                    }
                    menu(allMsg);
                    break;

                case 2 :
                    System.out.println("Show new message");
                    for (EmailMessage m : unReadMsg)
                    {
                        System.out.print(""+(i++)+". Subject : "+m.getSubject());
                        System.out.print("          From : "+m.getFromEmail());
                        System.out.println("    "+m.getLastModified());
                    }
                    menu(unReadMsg);
                    break;

                case 3 :
                    System.out.println("Show read message");
                    for (EmailMessage m : readMsg)
                    {
                        System.out.print(""+(i++)+". Subject : "+m.getSubject());
                        System.out.print("          From : "+m.getFromEmail());
                        System.out.println("    "+m.getLastModified());
                    }
                    menu(readMsg);
                    break;

                case 4 :
                    System.out.println("Show sent message");
                    for (EmailMessage m : sentMsg)
                    {
                        System.out.print(""+(i++)+". Subject : "+m.getSubject());
                        System.out.print("          From : "+m.getFromEmail());
                        System.out.println("    "+m.getLastModified());
                    }
                    menu(sentMsg);
                    break;
                case 5 :
                    System.out.println("Log out");
                    break;

                default: break;
            }
            i=1;
            readEmail();
        }while (number!=5);
    }
}
