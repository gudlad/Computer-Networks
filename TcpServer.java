import java.util.*;
import java.net.*;
import java.io.*;
public class TcpServer
{
private static class ClientHandler extends Thread{
private Socket socket;
ClientHandler(Socket socket)
{
System.out.println("Client connectd\n");
this.socket=socket;
}
public void run()
{
try {
BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
String file=reader.readLine().trim();
System.out.println("Requested file is:"+file);
FileReader fr=new FileReader(file);
BufferedReader br=new BufferedReader(fr);
String h=null;
while((h=br.readLine())!=null)
{
writer.println(h);
}
writer.close();
br.close();
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
} // end of run
} // end of class handler
public static void main(String args[])
{
final int port=9912;
try
{
ServerSocket ss=new ServerSocket(9912);
System.out.println("Listening........");
while(true)
{
Socket socket=ss.accept();
new ClientHandler(socket).start();
}
}
catch(IOException e)
{
e.printStackTrace();
}
}
} // end of class
