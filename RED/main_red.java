import java.util.Scanner;
import java.util.Random;

public class main_red
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Enter the maximum number of packets :  ");
        int max_packets = sc.nextInt();
        System.out.print("Enter the queue lsize :  ");
        int queue_size = sc.nextInt();
        System.out.print("Enter the minimum probability :  ");
        double min_probability = sc.nextDouble();
        System.out.print("Enter the maximum probability :  ");
        double max_probability = sc.nextDouble();
        
        int queue_length = 0;
        double drop_probability = min_probability;
        System.out.println("Controlling Congestion...");
        for( int x=0 ; x<max_packets ; x++ )
        {
            if( queue_length>=queue_size )
            {
                System.out.println("Packet Dropped (Queue Full)");
                drop_probability = min_probability;
            }
            else if( r.nextDouble() < drop_probability )
            {
                System.out.println("Packet Dropped (Random) ");
                drop_probability += (max_probability - min_probability)/(max_packets - 1);
            }
            else
            {
                System.out.println("Packet Accepted");
                queue_length++;
                drop_probability = min_probability;
            }
        }
        sc.close();
    }
}

/*
Enter the maximum number of packets :  15
Enter the queue lsize :  10
Enter the minimum probability :  0.3
Enter the maximum probability :  0.85
Controlling Congestion...
Packet Accepted
Packet Dropped (Random)
Packet Accepted
Packet Accepted
Packet Accepted
Packet Accepted
Packet Dropped (Random)
Packet Accepted
Packet Accepted
Packet Accepted
Packet Accepted
Packet Accepted
Packet Dropped (Queue Full)
Packet Dropped (Queue Full)
Packet Dropped (Queue Full)
 */