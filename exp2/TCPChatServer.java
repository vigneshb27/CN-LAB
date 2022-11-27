import java.util.*;
import java.io.*;
import java.net.*;

class TCPChatServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(1010);
        Socket s = ss.accept();
        DataInputStream is = new DataInputStream(s.getInputStream());
        DataInputStream in = new DataInputStream(System.in);
        DataOutputStream os = new DataOutputStream(s.getOutputStream());
        String line, st;
        while(true)
        {
            line = is.readUTF();
            if(line.equals("Close connection"))
            {
                break;
            }
            else
            {
                System.out.println(line);
            }
            st = in.readLine();
          
            if(st.equals("Close"))
            {
                os.writeUTF(st);
                break;
            }
            else
            {
                os.writeUTF(st);
            }
            

        }
        s.close();
        ss.close();
    }
}