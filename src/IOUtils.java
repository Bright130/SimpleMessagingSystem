import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IOUtils
{
    /**
     * Asks for a string and returns it as the value of the function
     * @param   prompt    String to print, telling which coordinate
     * @return  The string the user entered (maximum 100 chars long)
     */
    public static String getString(String prompt)
    {
        String inputString;
        int readBytes = 0;
        byte buffer[] = new byte[200];
        System.out.println(prompt);
        try
        {
            readBytes = System.in.read(buffer,0,200);
        }
        catch (IOException ioe)
        {
            System.out.println("Input/output exception - Exiting");
            System.exit(1);
        }
        inputString = new String(buffer);
        int pos = inputString.indexOf("\n");
        if (pos > 0)
            inputString = inputString.substring(0,pos);
        return inputString;
    }

    public static String getEmail()
    {

    }

    public static String getPassword()
    {

    }


    /**
     *  Creates and returns a string with the current date
     *  and time, to use as a time stamp.
     * @return date/time string in the form "yyyy-mm-dd hh:mm:ss"
     */
    public static String getDateTime()
    {
        Date now = new Date();
        SimpleDateFormat formatter =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(now);
    }
}
