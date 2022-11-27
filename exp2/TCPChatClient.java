import java.util.*;
import java.io.*;
import java.net.*;

class TCPChatClient{
    public static void main(String[] args) throws Exception
    {
        Socket soc = new Socket("localhost", 1010);
        DataOutputStream os = new DataOutputStream(soc.getOutputStream());
        DataInputStream is = new DataInputStream(soc.getInputStream());
        DataInputStream in = new DataInputStream(System.in);
        String s, y;
        while(true)
        {
            s = in.readLine();
            if(s.equals("Over"))
            {
                os.writeUTF("Close connection");
                break;
            }
            else
            {
                os.writeUTF(s);
            }
            y = is.readUTF();
            if(y.equals("Close"))
            {
                break;
            }
            else
            {
                System.out.println(y);
            
            }
        }

        soc.close();
    }
}