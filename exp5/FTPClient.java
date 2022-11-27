import java.util.*;
import java.net.*;
import java.io.*;

class FT {
    DataOutputStream os;
    DataInputStream is;
    DataInputStream in;
    File fname;
    Socket soc;

    FT() throws Exception 
    {
        soc = new Socket("localhost", 2088);
        os = new DataOutputStream(soc.getOutputStream());
        is = new DataInputStream(soc.getInputStream());
        in = new DataInputStream(System.in);
    }

    void operation() throws Exception
    {
        String name;
        System.out.println("File name : ");
        name = in.readLine();
        os.writeUTF(name);
        if((is.readUTF()).equals("Y"))
        {
            System.out.println("Enter the destination file name :");
            name = in.readLine();
            fname = new File(name);
            if(fname.exists())
            {
                System.out.println("File already exists, do you want to overwrite it? (Y/N)");
                name = in.readLine();
                if(name.equals("N"))
                {
                    os.writeUTF("N");
                    return;
                }
                else
                {
                    os.writeUTF("Y");
                    rec_file();
                }
            }
            else
            {
                os.writeUTF("Y");
                rec_file();
            }
        }
        else
        {
            System.out.println("File not found in the server");
        }
    }

    void rec_file() throws Exception
    {
        FileOutputStream fos = new FileOutputStream(fname);
        String st;
        while(true)
        {
            st = is.readUTF();
            int ch = Integer.parseInt(st);
            if(ch != -1)
            {
                fos.write(ch);
            }
            else
            {
                break;
            }
        }
        System.out.println("File transferred successfully");
     }

}

class FTPClient {
    public static void main(String[] args) throws Exception 
    {
        FT ft = new FT();
        ft.operation();
    }
    
}