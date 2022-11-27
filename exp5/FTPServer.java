import java.util.*;
import java.net.*;
import java.io.*;

class FileTransfer {
    public DataOutputStream os;
    public DataInputStream is;
    public DataInputStream in;
    public File fname;
    public ServerSocket ssoc;
    public Socket soc;


    FileTransfer() throws Exception
    {
        ssoc = new ServerSocket(2088);
        soc = ssoc.accept();
        os = new DataOutputStream(soc.getOutputStream());
        is = new DataInputStream(soc.getInputStream());
        in = new DataInputStream(System.in);
    }

    void operation() throws Exception
    {
        String name = is.readUTF();
        fname = new File(name);
        if(fname.exists())
        {
            os.writeUTF("Y");
            if((is.readUTF()).equals("Y"))
            {
                send_file();
            }
            else {}
        }
        else
        {
            os.writeUTF("N");
            System.out.println("File not found");
        }
    }

    void send_file() throws Exception
    {
        FileInputStream fis = new FileInputStream(fname);
        int ch;
        while(true)
        {
            ch = fis.read();
            os.writeUTF(String.valueOf(ch));
            
            if(ch == -1)
            {
                break;
            }
        }
        System.out.println("File Transfer Complete");
    }

}

class FTPServer {
    public static void main(String[] args) throws Exception
    {
        FileTransfer ft = new FileTransfer();
        ft.operation();
    }
}