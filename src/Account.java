import java.util.Date;
import java.lang.String

public class Account
{
    private String Email;

    private String Password;

    private Date LastUpdate;

    public void setEmail(String email)
    {
        Email = IOUtils.getEmail();
    }

    public void setPassword(String password)
    {
        Password = IOUtils.getPassword();
    }

    public void setLastUpdate(Date time)
    {
        LastUpdate = IOUtils.getDateTime();
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
