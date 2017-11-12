import java.lang.String;

public class EmailMessage
{
    private int id;

    private String lastRefresh;

    private String toAddress;

    private String fromAddress;

    private String subject;

    private String bodyText;

    private int isRead;

    private int isSenderDel;

    private int isReaderDel;

    EmailMessage()
    {
    }

    EmailMessage(String lastRefresh,String toAddress,String fromAddress,String subject,String bodyText,int isRead,int isSenderDel,int isReaderDel)
    {
        this.lastRefresh = lastRefresh;
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.subject = subject;
        this.bodyText = bodyText;
        this.isRead = isRead;
        this.isReaderDel = isReaderDel;
        this.isSenderDel = isSenderDel;
    }

    EmailMessage(int id,String lastRefresh,String toAddress,String fromAddress,String subject,String bodyText,int isRead,int isSenderDel,int isReaderDel){
        this.id = id;
        this.lastRefresh = lastRefresh;
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.subject = subject;
        this.bodyText = bodyText;
        this.isRead = isRead;
        this.isReaderDel = isReaderDel;
        this.isSenderDel = isSenderDel;
    }

    public void setLastRefresh(String date)
    {
        this.lastRefresh = date;
    }

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

    public void setBodyText(String bodyText)
    {
        this.bodyText = bodyText;
    }

    public void setIsRead(int isRead)
    {
        this.isRead = isRead;
    }

    public void setIsReaderDel(int delRead)
    {
        this.isReaderDel = delRead;
    }
    public void setIsSenderDel(int delSend)
    {
        this.isSenderDel = delSend;
    }

    public int getId() { return id; }

    public String getLastRefresh()
    {
        return lastRefresh;
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

    public String getBodyText()
    {
        return bodyText;
    }

    public int getIsRead()
    {
        return isRead;
    }
    public int getIsReaderDel()
    {
        return isReaderDel;
    }
    public int getIsSenderDel()
    {
        return isSenderDel;
    }

    public boolean send()
    {
        return true;
    }


}
