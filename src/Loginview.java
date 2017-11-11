public class Loginview
{
    public String login(AccountManager manager)
    {
        boolean check;
        String email;
        String password;

       do
       {
           email = IOUtils.getEmail();
           password = IOUtils.getPassword();
           check = manager.login(email,password);
           if(check==false)
           {
                System.out.println("Your login email or password is wrong!!");
                System.out.println("Please try again");
           }
       }while (check==false);

        return email;
    }
}
