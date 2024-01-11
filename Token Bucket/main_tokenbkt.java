import java.util.Scanner;

public class main_tokenbkt
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the Bucket Capacity :  ");
        int capacity = sc.nextInt();
        System.out.print("Enter the number of requests :  ");
        int n = sc.nextInt();
        int[] requests = new int[n];
        System.out.println("Enter the number of packets per request=>");
        for( int i=0 ; i<n ; i++ )
             requests[i] = sc.nextInt();
        
        int tokens = 0;
        int rate = 6;

        for( int i=0 ; i<n ; i++ )
        {
            tokens = Math.min((tokens+rate),capacity);
            System.out.print("->Number of tokens present : "+tokens);
            if( requests[i] <= tokens )
            {
                tokens -= requests[i];
                System.out.println(" Request GRANTED !! Tokens Remaining = "+tokens);
            }
            else
                System.out.println(" Request DENIED!! Tokens Remaining = "+tokens);
        }
        sc.close();
    }
}

