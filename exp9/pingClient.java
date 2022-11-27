import java.util.*;
import java.net.*;
import java.io.*;

class pingClient {
    public static void main(String args[]) throws Exception 
    {
        Socket soc = new Socket("localhost", 2156);
        DataInputStream is = new DataInputStream(soc.getInputStream());
        DataOutputStream os = new DataOutputStream(soc.getOutputStream());
        DataInputStream in = new DataInputStream(System.in);

        String ip;
        int packets;
        
        System.out.println("Enter the IP address to ping :");
        ip = in.readLine();
        System.out.println("Enter the number of packets to send :");
        packets = Integer.parseInt(in.readLine());
        System.out.println("enada");
        os.writeUTF("P");
        os.writeInt(packets);
        os.writeUTF("A");
        os.writeUTF(ip);

        String pingLine = is.readUTF();
        while(pingLine != null)
        {
            System.out.println(pingLine);
            pingLine = is.readUTF();
        }
        soc.close();
    }
    
}