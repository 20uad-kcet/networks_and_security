//This program calculates the Key for two persons
// using the Diffie-Hellman Key exchange algorithm
import java.util.*;

class GFG{
     
// Power function to return value of a ^ b mod P
private static long power(long a, long b, long p)
{
    if (b == 1)
        return a;
    else
        return (((long)Math.pow(a, b)) % p);
}
 
// Driver code
public static void main(String[] args)
{
    long P, G, x, a, y, b, ka, kb;
     
    // Both the persons will be agreed upon the
    // public keys G and P
     Scanner sc= new Scanner(System.in);  
    // A prime number P is taken
	System.out.println("Enter the prime key:");
	P= sc.nextLong();  

	
    // A primitive root for P, G is taken
         System.out.println("Enter the primitive root:");
	G= sc.nextLong();
    // Alice will choose the private key a
    // a is the chosen private key
    
     System.out.println("Enter the private key a for Alice:");
	a= sc.nextLong();
    // Gets the generated key
    x = power(G, a, P);
     
    // Bob will choose the private key b
    // b is the chosen private key   
     System.out.println("Enter the private key b for Bob:");
	b= sc.nextLong();
    // Gets the generated key
    y = power(G, b, P);
     
    // Generating the secret key after the exchange
    // of keys
    ka = power(y, a, P); // Secret key for Alice
    kb = power(x, b, P); // Secret key for Bob
     
    System.out.println("Secret key for the Alice is:" + ka);
    System.out.println("Secret key for the Bob is:" + kb);
}
}
 
