import java.util.Scanner;

class bellman_ford_algo
{
    private int[] distance;
    private int[][] M;
    private int n;

    public bellman_ford_algo(int[][] M,int n,int source)
    {
         this.M =M;
         this.n = n;
         distance = new int[n];
         for( int i=0 ; i<n ; i++ )
             distance[i] = 9999;
         distance[source] = 0;
    }

    public void short_path(int source)
    {
        boolean flag=true;
        int u,v;
        for( int i=1 ; i<=n ; i++ )
        {
            u=source; 
            do
            {
                v=0;
                do
                {
                    if( M[u][v]!=9999 )
                    {
                        if( distance[u]+M[u][v] < distance[v] )
                        {
                            distance[v] = distance[u]+M[u][v];
                            if( i==n )
                            { flag=false; break; }
                        }
                    }
                    v++;
                }while( v<n );
                u = (u+1)%n;
            }while( u!=source );
        }
        if( flag==false )
            System.out.println("\nNodes are having the 'Negative Edge Cycle' !! ");
        else
        {
            System.out.println("\nShortest Paths from =>");
            for( int i=0 ; i<n ; i++ )
               System.out.println(source+"-->"+i+" = "+distance[i]);
        }
        System.out.println();
    }
}

public class main_blmnfrd 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes :  ");
        int n= sc.nextInt();

        int[][] M = new int[n][n];
        System.out.println("Enter the Adjacency Matrix =>");
        System.out.println("Enter 9999 if edge doesn't exist");
        for( int i=0 ; i<n ; i++ )
        {
            for( int j=0 ; j<n ; j++ )
            {
                 M[i][j] = sc.nextInt();
                 if( i==j )
                    M[i][j] = 9999;
            }
        }
        System.out.println("Enter the source :  ");
        int source = sc.nextInt();
        bellman_ford_algo obj = new bellman_ford_algo(M,n,source);
        obj.short_path(source);
        sc.close();
    }
}

/*
1)
Enter the number of nodes :  5
Enter the Adjacency Matrix =>
Enter 9999 if edge doesn't exist
0 4 2 9999 9999
9999 0 3 2 3
9999 1 0 4 5
9999 9999 9999 0 9999
9999 9999 9999 -5 0 
Enter the source :
2

Shortest Paths=>
source-->0 = 9999
source-->1 = 1
source-->2 = 0
source-->3 = -1
source-->4 = 4

2)
Enter the number of nodes :  5
Enter the Adjacency Matrix =>
Enter 9999 if edge doesn't exist
0 4 2 9999 9999
9999 0 3 2 3
9999 1 0 4 5
9999 9999 9999 0 9999
9999 9999 9999 -5 0
Enter the source :
0

Shortest Paths from =>
0-->0 = 0
0-->1 = 3
0-->2 = 2
0-->3 = 1
0-->4 = 6

3)
Enter the number of nodes :  6
Enter the Adjacency Matrix =>
Enter 9999 if edge doesn't exist
9999 5 9999 9999 9999 9999 
9999 9999 1 2 9999 9999
9999 9999 9999 9999 1 9999
9999 9999 9999 9999 9999 2 
9999 9999 9999 -1 9999 9999
9999 9999 9999 9999 -3 9999
Enter the source :
4

Nodes are having the 'Negative Edge Cycle' !!

 */