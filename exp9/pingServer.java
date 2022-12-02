import java.util.*;
import java.net.*;
import java.io.*;

class pingServer {
    public static void main(String args[]) throws Exception
    {
        ServerSocket ss = new ServerSocket(2156);
        Socket soc = ss.accept();
        System.out.println("Connection established");

        DataInputStream is = new DataInputStream(soc.getInputStream());
        DataOutputStream os = new DataOutputStream(soc.getOutputStream());

        String ip = "";
        int packets = 0;

        if((is.readUTF()).equals("P"))
        {
            System.out.println("Getting packets...");
            packets = is.readInt();
        }
        if((is.readUTF()).equals("A"))
        {
            System.out.println("Getting ip...");
            ip = is.readUTF();
        }
        System.out.println(packets);
        System.out.println(ip);

       
        Process p = Runtime.getRuntime().exec("ping -n "+ packets + " " +ip);
        System.out.println("Running ping -n "+ packets + " " + ip);

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        line = br.readLine();
        System.out.println(line);
        
        while(line != null)
        {
            os.writeUTF(line);
            line = br.readLine();
        }
            
        
       
        soc.close();
        ss.close();
    }
}
