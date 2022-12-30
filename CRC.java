import java.util.*;

public class CRC{
public static void main(String args[])
{
Scanner s=new Scanner(System.in);
System.out.println("Enter the no of data bits:");
int n=s.nextInt();
int[] data=new int[n];
System.out.println("Enter the data bits:");
for(int i=0;i<n;i++)
	data[i]=s.nextInt();

System.out.println("Enter the no of division bits:");
int m=s.nextInt();
int[] divisor=new int[m];
System.out.println("Enter the division bits:");
for(int i=0;i<n;i++)
	divisor[i]=s.nextInt();
	
int len=n+m-1;
int[] div=new int[len];
int[] rem=new int[len];
int[] crc=new int[len];

for(int i=0;i<data.length;i++)
	div[i]=data[i];
System.out.println("dividend after appending zeroes");
for(int i=0;i<div.length;i++)
	System.out.println(div[i]);
for(int i=0;i<div.length;i++)
	rem[i]=div[i];
rem=divide(div,divisor,rem);
for(int i=0;i<div.length;i++)
	crc[i]=rem[i]^div[i];
System.out.println("crc code");
for(int i=0;i<crc.length;i++)
	System.out.println(crc[i]);

int[] mancrc=new int[crc.length];
System.out.println("Enter the "+crc.length+ "bit crc code");
for(int i=0;i<crc.length;i++)
	mancrc[i]=s.nextInt();
boolean issame=Arrays.equals(crc,mancrc);
if(issame)
	System.out.println("No error");
else
	System.out.println("Error!! crc code doesn't match..");


} // main
public static int[] divide(int[] div,int[] division,int[] rem)
{
int cur=0;
while(true)
{
for(int i=0;i<division.length;i++)
{
rem[cur+i]=rem[cur+i]^division[i];
}
while(rem[cur]==0 && cur!=rem.length-1)
	cur++;
if(rem.length-cur<division.length)
	break;
}
return rem;
}
} // end of class
