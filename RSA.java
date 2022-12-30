import java.util.*;

public class RSA
{
public static void main(String args[])
{
Scanner s=new Scanner(System.in);
System.out.println("Enter first prime number:");
int p=s.nextInt();
System.out.println("Enter second prime number:");
int q=s.nextInt();
int n=p*q;
int z=(p-1)*(q-1);
System.out.println("Enter the value of e(integer)");
int e=s.nextInt();
while(true)
{
if(GCD(z,e)!=1)
{
System.out.println("Enter the valid value of e:");
}
else
	break;
}
int d=findD(e,z);
System.out.println("The value of d is :"+d);
System.out.println("Enter the message(integer):");
int m=s.nextInt();
int c=(int)((Math.pow(m,e))%n);
System.out.println("The value of Cypher is:"+c);
int x=(int)((Math.pow(c,d))%n);
System.out.println("The message after decryption is "+x);
if(x==m)
	System.out.println("input matched");
else 
	System.out.println("input mismatched");
}

static int findD(int e,int z)
{
int b;
for(int i=1;i<z;i++)
{
 b=(e*i)%z;
 if(b==1)
 {
 return i;
 }
}
return 0;
}

static int GCD(int number1,int number2)
{
if(number2==0)
	return number1;
return GCD(number2,number1%number2);
}



}
