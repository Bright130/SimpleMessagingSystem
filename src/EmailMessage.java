import java.util.ArrayList;
import java.util.Date;

public class EmailMessage
{
    private Date created;

    private String toAddress;

    private String fromAddress;

    private String subject;

    private ArrayList<String> bodyText;

    private String messageState;

    public void setToEmail(String toAddress)
    {
        this.toAddress = toAddress;
    }

    public void setFromEmail(String fromAddress)
    {
        this.fromAddress = fromAddress;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public void setBodyText(ArrayList<String> bodyText)
    {
        this.bodyText = bodyText;
    }

    public void setMessageState(String messageState)
    {
        this.messageState = messageState;
    }

    public Date getCreated()
    {
        return created;
    }

    public String getToEmail()
    {
        return toAddress;
    }

    public String getFromEmail()
    {
        return fromAddress;
    }

    public String getSubject()
    {
        return subject;
    }

    public ArrayList<String> getBodyText()
    {
        return bodyText;
    }

    public boolean send()
    {
        return true;
    }
}
