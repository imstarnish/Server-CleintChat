import java.io.*;
import java.net.*;
import java.util.*;
public class TcpClient {
public static void main(String[] args){
try{
//Thread.sleep(1000);
Socket s2=new Socket("172.17.14.19",6666);

DataInputStream dis=new DataInputStream(s2.getInputStream());
DataOutputStream dout=new DataOutputStream(s2.getOutputStream());
Scanner sc=new Scanner(System.in);

while(true)
{

	System.out.print("\nEnter Message:");
	String str=sc.nextLine();
	dout.writeUTF(str);
	if(str.equals("end."))
	{break;}
	str=(String)dis.readUTF();
	System.out.println("\n"+str);
	if(str.equals("end."))
	{break;}
}
dout.flush();  
dout.close();  
s2.close(); 

}catch(Exception e){System.out.println(e);}
}
}