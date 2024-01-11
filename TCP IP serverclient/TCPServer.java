import java.io.*;
import java.net.*;

public class TCPServer
{
    public static void main( String[] args ) throws Exception
    {
        ServerSocket ser_soc = new ServerSocket(4000);
        Socket soc = ser_soc.accept();

        //Receiveing the file name
        InputStream i = soc.getInputStream();
        BufferedReader rd = new BufferedReader( new InputStreamReader(i) );
        String fname = rd.readLine();

        // Redaing the file contents and sending to client
        BufferedReader rd1 = new BufferedReader( new FileReader(fname) );
        
        OutputStream o = soc.getOutputStream();
        PrintWriter p = new PrintWriter( o , true );
        
        String str;
        while( (str=rd1.readLine())!=null )
        { p.print(str+"\n"); }

        p.close();
        o.close();
        i.close();
        soc.close();
        ser_soc.close();
    }
}




































