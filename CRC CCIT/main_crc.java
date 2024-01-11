import java.util.Scanner;

class crc_ccit
{
    private String codeword;
    private int gl,cl;
    private int[] divisor;

    public crc_ccit(String dataword,String generator)
    {
        codeword = dataword;
        gl = generator.length();
        divisor = new int[gl];
        for( int i=0 ; i<gl ; i++ )
            divisor[i] = Integer.parseInt(""+generator.charAt(i));
        int dl = dataword.length();
        cl = dl+gl-1;
        for( int i=0 ; i<(gl-1) ; i++ )
           codeword += '0';
    }

    public int[] division( String dividend )
    {
        int[] codeword_arr = new int[cl];
        for( int i=0 ; i<cl ; i++ )
            codeword_arr[i] = Integer.parseInt(""+dividend.charAt(i));
        for( int i=0 ; i<=cl-gl ; i++ )
        {
            if( codeword_arr[i]==0 )
                continue;
            else
            {
                for( int j=0 ; j<gl ; j++ )
                    codeword_arr[i+j] ^= divisor[j]; 
            }
        }
        return codeword_arr;
    }

    public void generate_codeword()
    {
       int[] codeword0 = division(codeword);
       System.out.println("Checksum=>");
       for( int i=(cl-gl+1) ; i<cl ; i++ )
           System.out.print(codeword0[i]);
       System.out.println("\n");

       System.out.println("Codeword=>");
       for( int i=0 ; i<=cl-gl ; i++ )
           System.out.print(codeword.charAt(i));
       for( int i=(cl-gl+1) ; i<cl ; i++ )
           System.out.print(codeword0[i]);
       System.out.println("\n");
    }
}

public class main_crc 
{
    public static boolean check_1s(int[] arr)
    {
        for( int i=0 ; i<arr.length ; i++ )
          if( arr[i]==1 )
             return true;
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String polynomial, generator, received_word;

        System.out.print("Enter the Polynomial :  ");
        polynomial = sc.next();
        System.out.print("Enter the generator :  ");
        generator = sc.next();
        crc_ccit o = new crc_ccit(polynomial,generator);
        o.generate_codeword();

        System.out.print("Enter the received word :  ");
        received_word = sc.next();
        int[] dividend = o.division(received_word);

        if( check_1s(dividend) )
            System.out.println("Received word have ERRORS!!");
        else
            System.out.println("Received word has NO ERRORS!!");
        sc.close();
    }
}

/*
 1)
Enter the Polynomial :  100111011010
Enter the generator :  101011
Checksum=>
01110

Codeword=>
10011101101001110

Enter the received word :  10010101101001110
Received word have ERRORS!!

 2)
Enter the Polynomial :  110010100101
Enter the generator :  1011011
Checksum=>
101001

Codeword=>
110010100101101001

Enter the received word :  110010100101101001
Received word has NO ERRORS!!
 */
