import java.util.*;
import java.io.*;
import java.net.*;

class TCPEchoServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(8080);
        Socket s = ss.accept();
        DataInputStream is = new DataInputStream(s.getInputStream());
        //DataOutputStream os = new DataOutputStream(System.out);
        String line;
        while(true)
        {
            line = is.readUTF();
            if(line.equals("Close connection"))
            {
                break;
            }
            else{
                System.out.println(line);
            }
        }
        s.close();
        ss.close();
    }
}