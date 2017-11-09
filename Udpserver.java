import java.io.*;
import java.net.*;
import java.util.*;

public class Udpserver
{
public static void main(String args[]) throws Exception
{
try
{
DatagramSocket serverSocket = new DatagramSocket(7777);
     
     
     String str;
     Scanner sc= new Scanner(System.in);
     
     DatagramPacket receivePacket;
     int port;
     InetAddress IPAddress;
     DatagramPacket sendPacket;
     
     while(true)
     {
     byte[] receiveData = new byte[1024];
     byte[] sendData = new byte[1024];
     
     receivePacket = new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket); 
     byte[] d= trim(receivePacket.getData());  
         str= new String(d);
         str.trim();
          System.out.println("\nRecieved message:\t"+str);
if(str.equals("end."))
break;
IPAddress = receivePacket.getAddress();
           port = receivePacket.getPort();
           
          System.out.print("\nEnter the message:\t");
str=sc.nextLine();
           sendData=str.getBytes();
           sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
serverSocket.send(sendPacket);
if(str.equals("end."))
break;
     }
     serverSocket.close();
     
     }
     catch(Exception e)
     {
     
     }
} 
static byte[] trim(byte[] bytes) 
{ 
int i = bytes.length - 1; 
while (i >= 0 && bytes[i] == 0) 
{
 --i;
} 
return Arrays.copyOf(bytes, i + 1); 
}
}