import java.io.*;
import java.net.*;
import java.util.*;
public class UdpClient {
	static byte[] trim(byte[] bytes)
{
    int i = bytes.length - 1;
    while (i >= 0 && bytes[i] == 0)
    {
        --i;
    }

    return Arrays.copyOf(bytes, i + 1);
}

public static void main(String[] args){
	try
	{
	Scanner sc=new Scanner(System.in);
	DatagramSocket clientSocket = new DatagramSocket();
 	InetAddress IPAddress = InetAddress.getByName("172.17.14.19");
    System.out.println("Connecting to Server....");
    byte[] sendData = new byte[1024];
    byte[] receiveData = new byte[1024];
    while(true)
    {
    System.out.print("\nEnter message: ");
    String s = sc.nextLine();
    sendData = s.getBytes();
    sendData=trim(sendData);
    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 7777);
    clientSocket.send(sendPacket);
    if(s.equals("end.")){break;}
    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
    clientSocket.receive(receivePacket);
    String message = new String(trim(receivePacket.getData()));
    System.out.print("\nRecieved Message:"+message);
    if(message.equals("end.")){break;}
	}
clientSocket.close(); 
}catch(Exception e){System.out.println(e);}
}
}