import java.util.*;
import java.net.*;
import java.io.*;
public class TcpClient
{
public static void main(String args[])
{
Socket socket=null;
try
{
socket=new Socket(InetAddress.getLocalHost().getHostName(),9912);
BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
System.out.println("Enter the filename:");
Scanner s=new Scanner(System.in);
String file=s.nextLine();
writer.println(file);
System.out.println("Reading Client..................");
String h=null;
while((h=reader.readLine())!=null)
{
System.out.println(h);
}
}
catch(IOException e)
{
e.printStackTrace();
}
finally
{
try
{
socket.close();
}
catch(IOException e)
{
e.printStackTrace();
}
}
}
}





























