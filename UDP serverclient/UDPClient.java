import java.net.*;
import java.io.*;

public class UDPClient
{
    public static void main( String[] args ) throws Exception
    {
        DatagramSocket client_socket = new DatagramSocket();
        InetAddress IPADDRESS = InetAddress.getByName("localhost");

        while( true )
        {
           //Sending the lower case letters to Server
            BufferedReader rd = new BufferedReader( new InputStreamReader( System.in ) );
            System.out.println("Enter the message in lowercase :  ");
            String msg = rd.readLine();
            byte[] send_data = new byte[1024];
            send_data = msg.getBytes();

            DatagramPacket sender_packet = new DatagramPacket( send_data, send_data.length , IPADDRESS , 9876 );
            client_socket.send(sender_packet);


            //Receiving the Uppercase letters from Server
            byte[] receive_data = new byte[1024];
            DatagramPacket receiver_packet = new DatagramPacket( receive_data , receive_data.length );
            client_socket.receive(receiver_packet);
            String Umsg = new String( receiver_packet.getData() );
            System.out.println("Message from Server :  "+Umsg);
            client_socket.close();
        }
    }
}
