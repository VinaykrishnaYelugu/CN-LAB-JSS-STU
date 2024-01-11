import java.util.Scanner;
import java.util.ArrayList;

class leaky_bucket_algo
{
    private ArrayList<Integer> packets;
    private int rate,capacity,accept,send,remaining;

    public leaky_bucket_algo(int capacity, int rate, ArrayList<Integer> packets)
    {
        this.capacity = capacity;
        this.rate = rate;
        this.packets = packets;
        accept = 0 ; send = 0 ; remaining = 0;
    }

    public void congestion_control()
    {
        int clock = 0;
        System.out.println("Clock\tPacket Size\tAccepted\tSent\tRemaining");
        for( int packet : packets )
        {
            // Receiving packet
            if( packet+remaining <= capacity )
            {
                accept = packet;
                remaining+=accept;
            }
            else
                accept = 0;

            // Sending packets
            if( remaining<rate )
                send = remaining;
            else
                send = rate;
            remaining -= send;

            clock++;

           // display
            if( accept==0 && packet!=0 )
               System.out.println(" "+clock+" "+"\t"+"   "+packet+"   "+"\t\t"+" dropped"+"  \t "+send+"    "+"\t"+" "+remaining);
            else
               System.out.println(" "+clock+" "+"\t"+"   "+packet+"   "+"\t\t"+"   "+accept+"   "+"\t\t "+send+"    "+"\t"+" "+remaining);
        }
    }
}

public class main_lkbkt 
{
    public static void main( String[] args )
    {
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter the bucket capacity :  ");
         int capacity = sc.nextInt();
         System.out.print("Enter the constant output rate :  ");
         int rate = sc.nextInt();
         System.out.print("Enter the packet size or -1 to stop\n");
         ArrayList<Integer> packets = new ArrayList<Integer> ();
         int size;
         while( true )
         {
             size = sc.nextInt();
             if( size==-1 )
                 break;
             packets.add(size);
         }
         leaky_bucket_algo o = new leaky_bucket_algo(capacity, rate, packets);
         o.congestion_control();
         sc.close();
    }
}

/*
1)
Enter the bucket capacity :  6
Enter the constant output rate :  2
Enter the packet size or -1 to stop
2
3
4
6
-1
Clock   Packet Size     Accepted        Sent    Remaining
 1         2               2             2       0
 2         3               3             2       1
 3         4               4             2       3
 4         6             dropped         2       1


 2)
Enter the bucket capacity :  4
Enter the constant output rate :  3
Enter the packet size or -1 to stop
2
4
1
5
3
-1
Clock   Packet Size     Accepted        Sent    Remaining
 1         2               2             2       0
 2         4               4             3       1
 3         1               1             2       0
 4       dropped           0             0       0
 5         3               3             3       0

 */
