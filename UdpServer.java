import java.util.*;
import java.net.*;
import java.io.*;

public class UdpServer
{
public static void main(String args[]) throws Exception
{
System.out.println("Server");
byte[] buf=new byte[1024];
DatagramSocket ds=new DatagramSocket(3000);
while(true)
{
DatagramPacket dp=new DatagramPacket(buf,1024);
ds.receive(dp);
String msg=new String(dp.getData(),0,dp.getLength());
System.out.println(msg);
}
}
}
