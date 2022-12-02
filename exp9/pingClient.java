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
        os.writeUTF("P");
        os.writeInt(packets);
        os.writeUTF("A");
        os.writeUTF(ip);

        
        BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        String pingLine = br.readLine();
        while(pingLine != null)
        {
            System.out.println(pingLine);
            pingLine = br.readLine();
        }
        soc.close();
    }
    
}
