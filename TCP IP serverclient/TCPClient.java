import java.net.*;
import java.io.*;

public class TCPClient{
    public static void main( String[] args ) throws Exception
    {
        Socket soc = new Socket("127.0.01",4000);

        BufferedReader rd = new BufferedReader( new InputStreamReader(System.in) );
        
        // Sending the file name to the server
        System.out.print("Enter the file name :  ");
        String fname = rd.readLine();

        OutputStream o = soc.getOutputStream();
        PrintWriter p = new PrintWriter( o , true );
        p.println(fname);

        //Receiving the file contents
        InputStream i = soc.getInputStream();
        BufferedReader rd1 = new BufferedReader( new InputStreamReader(i) );
        String str;
        while( (str=rd1.readLine())!=null )
        {
            System.out.println(str);
        }
        
        i.close();
        p.close();
        o.close();
        soc.close();
    }
}










































// import java.net.*;
// import java.io.*;

// public class TCPClient
// {
//     public static void main(String[] args) throws Exception
//     {
//         Socket soc = new Socket( "127.0.01" , 4000 );

//         BufferedReader rd = new BufferedReader( new InputStreamReader(System.in) );
//         System.out.print("Enter the file name :  ");
//         String fname = rd.readLine();

//         // Sending the file name to server
//         OutputStream o = soc.getOutputStream();
//         PrintWriter p = new PrintWriter( o , true );
//         p.println(fname);

//         // Receiving the file contens from the server
//         InputStream i = soc.getInputStream();
//         BufferedReader rd1 = new BufferedReader( new InputStreamReader(i) );
//         String str;

//         while( (str=rd1.readLine())!=null )
//         {
//             System.out.print(str);
//         }

//         i.close();
//         o.close();
//         p.close();
//         soc.close();
//     }
// }