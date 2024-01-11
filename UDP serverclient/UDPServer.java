import java.net.*;
import java.io.*;

public class UDPServer
{
    public static void main( String[] args ) throws Exception
    {
        DatagramSocket server_socket = new DatagramSocket( 9876);

        while( true )
        {
            System.out.println("Server is Up!!");

            //Receiving the client's message
            byte[] receive_data = new byte[1024];
            DatagramPacket receiver_packet = new DatagramPacket( receive_data, receive_data.length );
            server_socket.receive(receiver_packet);

            String Lmsg = new String( receiver_packet.getData() );
            String Umsg = Lmsg.toUpperCase();

            //Sending the Uppercase message to the client
            InetAddress IPADDRESS = receiver_packet.getAddress();
            int port = receiver_packet.getPort();
            byte[] send_data = new byte[1024];
            send_data = Umsg.getBytes();
            
            DatagramPacket sender_packet = new DatagramPacket( send_data , send_data.length , IPADDRESS , port );
            server_socket.send(sender_packet);

            server_socket.close();
        }
    }
}












































// import java.net.*;
// import java.io.*;

// public class UDPServer
// {
//     public static void main( String[] args )throws Exception
//     {
//         DatagramSocket server_socket = new DatagramSocket(9876);
//         System.out.println("Server is UP !!");

//         //Receiving the message from the Client
//         byte[] receive_data = new byte[1024];
//         DatagramPacket receiver_packet = new DatagramPacket( receive_data , receive_data.length );
//         server_socket.receive( receiver_packet );
//         String msg = new String( receiver_packet.getData() );

//         //Converting into Upper Case
//         msg = msg.toUpperCase();

//         //Sending the message back to Client
//         byte[] send_data = new byte[1024];
//         send_data = msg.getBytes();
//         InetAddress IPADDRESS = receiver_packet.getAddress();
//         int port = receiver_packet.getPort();

//         DatagramPacket sender_data = new DatagramPacket( send_data , send_data.length , IPADDRESS , port );
//         server_socket.send( sender_data );

//         server_socket.close();
//     }
// }































































// // import java.io.*;
// // import java.net.*;

// // public class UDPServer
// // {
// //     public static void main( String[] args ) throws Exception
// //     {
// //         DatagramSocket server_socket = new DatagramSocket(9876);
// //         System.out.println("Server Up");

// //         byte[] received_data = new byte[1024];
// //         byte[] sent_data = new byte[1024];

// //         // Receiving data from Client
// //         DatagramPacket receiver_packet = new DatagramPacket(received_data , received_data.length);
// //         server_socket.receive( receiver_packet );
// //         String str = new String( receiver_packet.getData() );
// //         System.out.println("Received Data=>\n"+str);

// //         //Coverting to Upper Case
// //         str = str.toUpperCase();

// //         InetAddress IPADDRESS = receiver_packet.getAddress();
// //         int port = receiver_packet.getPort();
// //         sent_data = str.getBytes();


// //         // Sending the data to client
// //         DatagramPacket sender_packet = new DatagramPacket( sent_data , sent_data.length, IPADDRESS , port );
// //         server_socket.send( sender_packet );
// //         server_socket.close();
// //     }
// // }