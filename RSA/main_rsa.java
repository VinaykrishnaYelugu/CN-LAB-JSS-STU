import java.util.Scanner;

class rsa_algo
{
    private long n,phi,pub_key,pvt_key;

    public rsa_algo(long p,long q)
    {
        n = p*q;
        phi = (p-1)*(q-1);
    }

    public long gcd(long m,long n)
    {
        long r;
        while( n!=0 )
        {
            r = m%n ;
            m = n;
            n = r;
        }
        return m;
    }

    public void generate_keys()
    {
        pub_key = 2;
        while( pub_key<phi )
        {
            if( gcd(pub_key,phi)==1 )
                break;
            pub_key++;
        }

        pvt_key = 1;
        while( (pub_key*pvt_key)%phi!=1 )
        { pvt_key++; }
        System.out.println("Pulic Key :   "+pub_key+"\nPrivate Key :   "+pvt_key);
    }

    public long conversion(long x, long key)
    {
        long t=1;
        while( key>0 )
        {
            t = (t*x)%n;
            key--;
        }
        return t;
    }

    public long[] encryption(String plaintext)
    {
        int l = plaintext.length();
        long[] ciphers = new long[l];
        for( int i=0 ; i<l ; i++ )
            ciphers[i] = conversion((int)plaintext.charAt(i),pub_key);
        return ciphers;
    }

    public String decryption(long[] ciphers)
    {
        String ciphertext = "";
        int l = ciphers.length;
        for( int i=0 ; i<l ; i++ )
            ciphertext += (char)(conversion( ciphers[i],pvt_key));
        return ciphertext;
    }

}

public class main_rsa {
    public static void main(String[] arsg)
    {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter the 2 large prime number :  "); 
       long p = sc.nextLong();
       long q = sc.nextLong();
       rsa_algo o = new rsa_algo(p,q);
       o.generate_keys();

       // Encryption 
       System.out.print("Enter the plaintext :  "); 
       Scanner sc1 = new Scanner(System.in);
       String plaintext = sc1.nextLine();
       sc1.close();
       System.out.println("Encrpting....");
       long[] ciphers = o.encryption(plaintext);
       System.out.print("\nCipher Text=>\n [ ");
       for( long x : ciphers)
          System.out.print(" "+x);
       System.out.println(" ]\n");

       //Decryption
       System.out.println("Decrypting....");
       String ciphertext = o.decryption(ciphers);
       System.out.println("Plain text : "+ciphertext);
       sc.close();
    }
}

/*
Enter the 2 large prime number :  101 113
Pulic Key :   3
Private Key :   7467
Enter the plaintext :  Vinay Krishna 87615 *(&%$ .,<\>
Encrpting....

Cipher Text=>
 [  8341 4912 7092 11046 2546 9942 11007 9267 4912 2946 6390 7092 11046 9942 4421 6593 9095 3519 508 9942 5610 6935 9220 5001 1004 9942 6032 5293 10566 2604 10068 ]

Decrypting....
Plain text : Vinay Krishna 87615 *(&%$ .,<\>
 */