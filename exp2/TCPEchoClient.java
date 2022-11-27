import java.util.*;
import java.io.*;
import java.net.*;

class TCPEchoClient{
    public static void main(String[] args) throws Exception
    {
        Socket soc = new Socket("localhost", 8080);
        DataOutputStream out = new DataOutputStream(soc.getOutputStream());
        DataInputStream in = new DataInputStream(System.in);
        String s;
        while(true)
        {
            s = in.readLine();
            if(s.equals("Over"))
            {
                out.writeUTF("Close connection");
                break;
            }
            else
            {
                out.writeUTF(s);
            }
        }

        soc.close();
    }
}