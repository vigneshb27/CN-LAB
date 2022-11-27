import java.util.*;
import java.io.*;
import java.net.*;

class dnsServer
{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket server = new DatagramSocket(1309);
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);
        server.receive(dp);
        int port = dp.getPort();
        InetAddress ad = dp.getAddress();
        String s = new String(dp.getData());
        s = s.trim();
                
        String[] ip = {"8.8.8.8", "208.65.153.238"};
        String[] web = {"www.google.com", "www.youtube.com"};

        for(int i = 0; i < ip.length; i++)
        {
            if(s.equals(ip[i]))
            {
                              
                server.send(new DatagramPacket(web[i].getBytes(), web[i].length(), ad, port));
                break;
            }
            else if(s.equals(web[i]))
            {
                                
                server.send(new DatagramPacket(ip[i].getBytes(), ip[i].length(), ad, port));
                break;
            }
        }
    }
}