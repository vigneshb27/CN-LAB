import java.util.*;
import java.net.*;
import java.io.*;

class HTTPPostClient {
    public static void main(String args[]) throws Exception
    {
        Socket soc = new Socket("localhost", 6789);
        DataOutputStream os = new DataOutputStream(soc.getOutputStream());
        DataInputStream is = new DataInputStream(soc.getInputStream());
        DataInputStream in = new DataInputStream(System.in);
        String s, t;
        s = in.readLine();
        os.writeUTF(s);
        t = is.readUTF();
        System.out.println(t);
        soc.close();
    }
        
}