import java.net.*;
import java.io.*;
import java.util.*;
 
public  class UdpClient
{
public static void main(String args[]) throws Exception
{
System.out.println("Client");
Scanner s=new Scanner(System.in);
DatagramSocket ds=new DatagramSocket();
System.out.println("Enter the message......");
while(true)
{
String msg=s.nextLine();
InetAddress ip=InetAddress.getByName("127.0.0.1");
DatagramPacket dp=new DatagramPacket(msg.getBytes(),msg.length(),ip,3000);
ds.send(dp);
}
}
}
