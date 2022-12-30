import java.util.*;

public class BFA
{
public static final int max=999;
public static void main(String args[])
{
Scanner s=new Scanner(System.in);
System.out.println("Implementation of BFA algorithm");
int[] k=new int[10];
int[][] a=new int[30][30];
System.out.println("Enter the no of nodes:");
int n=s.nextInt();
System.out.println("Enter the adjacency matrix");
for(int i=1;i<=n;i++)
{
for(int j=1;j<=n;j++)
{
 a[i][j]=s.nextInt();
 if(a[i][j]==0)
 {
  a[i][j]=max;
  }
}
}

System.out.println("Adjacency matrix");
for(int i=1;i<=n;i++)
{
for(int j=1;j<=n;j++)
{
System.out.print(a[i][j]+" ");
}
System.out.println();
}

System.out.println("enter the destination vector:");
int d=s.nextInt();
if(d<=n)
{
for(int i=1;i<=n;i++)
{
 k[i]=max;
}
k[d]=0;

// logic
for(int i=1;i<=n-1;i++)
{
for(int x=1;x<=n;x++)
{
for(int y=1;y<=n;y++)
{
 if(a[x][y]!=max)
   if(k[y]>k[x]+a[x][y])
   	k[y]=k[x]+a[x][y];
}
}
}

for(int x=1;x<=n;x++)
{
for(int y=1;y<=n;y++)
{
 if(a[x][y]!=max)
   if(k[y]>k[x]+a[x][y])
   	System.out.println("Negative edge cycle");
}
}

for(int i=1;i<=n;i++)
{
System.out.println("The minimum distance from node "+i+" node"+d+" is"+k[i]);
}
} // end of if
}// end of main
} // end of class





