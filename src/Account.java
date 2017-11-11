import java.util.Date;

public class Account
{
    private String Email;

    private String Password;

    private Date LastUpdate;

    public void setEmail(String email)
    {

    }

    public void setPassword(String password)
    {

    }

    public void setLastUpdate(Date time)
    {

    }

    public String getEmail()
    {
        return Email;
    }

    public String getPassword()
    {
        return Password;
    }

    public Date getLastUpdate()
    {
        return LastUpdate;
    }

    public boolean sendMessage(EmailMessage msg)
    {
        return true;
    }
}
