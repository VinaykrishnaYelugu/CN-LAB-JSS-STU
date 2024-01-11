import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

class frames_class
{
    int data,sequence;
    public frames_class(int data,int sequence)
    {
        this.data = data;
        this.sequence = sequence;
    }
}

public class Framesort
{
    public static void display(ArrayList<frames_class> frames)
    {
        System.out.println("Sequence number\tMessage");
        for( frames_class x : frames )
            System.out.println("   "+x.sequence+"       \t   "+x.data);
        System.out.println("\n");
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        ArrayList<frames_class> frames;

        System.out.print("Enter the number of frames :  ");
        int n = sc.nextInt();
        frames = new ArrayList<frames_class>();
        int data, sequence;
        System.out.print("Enter the frame data :  ");
        for( int i=0 ; i<n ; i++ )
        {
            data = sc.nextInt();
            sequence = r.nextInt(10000);
            frames.add( new frames_class(data,sequence) );
        }
        Collections.shuffle(frames);

        System.out.println("->Before Sorting...");
        display(frames);

        System.out.println("->After Sorting...");
        Collections.sort( frames , (f1,f2) -> Integer.compare(f1.sequence,f2.sequence) );
        display(frames);

        sc.close();
    }
}