import java.util.*;
public class LBA
{
public static void main(String args[])
{
int OP;
Scanner s=new Scanner(System.in);
int remain=0;
int bktCap=0;
System.out.println("Enter the bucket capacity:");
bktCap=s.nextInt();
System.out.println("Enter the no of values:");
int n=s.nextInt();
int[] pkt=new int[10];
System.out.println("Enter the output data rate:");
int dr=s.nextInt();
System.out.println("Enter the values");
for(int i=0;i<n;i++)
{
pkt[i]=s.nextInt();
}

for(int i=0;i<=n;i++)
{
int total=pkt[i]+remain;

if(total>bktCap)
{
if(pkt[i]>bktCap)
{
System.out.println("The income packet size of "+pkt[i]+" is greater than the bucket capacity of "+bktCap);
System.out.println("The packet size exceeded and packet is rejected\n");
}
else
{
System.out.println("The packet size exceeded and packet is rejected");
}
}


else
{
remain+=pkt[i];
System.out.println("The incoming packet size is "+pkt[i]);
if(remain<=dr)
{
OP=remain;
remain=0;
}
else
{
OP=dr;
remain-=dr;
}
System.out.println("The packet of size "+OP+ " is transmitted");
System.out.println("The remaining capacity is  "+remain);
System.out.println();
}

}// end big for




} // end of main
} // end of class
