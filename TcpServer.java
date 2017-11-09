import java.io.*;
import java.net.*;
import java.util.*;

public class TcpServer
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();

			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
			Scanner sc= new Scanner(System.in);
			
			String str;
			
			while(true)
			{

				str=(String)dis.readUTF();
				System.out.println("Recieved message:\t"+str);
				if(str.equals("end."))
					break;
				
				System.out.print("\nEnter the message:\t");
				str=sc.nextLine();
				dout.writeUTF(str);  
				if(str.equals("end."))
					break;
			}	

			ss.close();

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}