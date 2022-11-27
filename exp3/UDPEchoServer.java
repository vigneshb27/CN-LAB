import java.util.*;
import java.net.*;
import java.io.*;

class UDPEchoServer
{
    public static void main(String args[]) throws Exception
    {
        int cport = 789;
        int sport = 780;
        InetAddress ad = InetAddress.getLocalHost();
        DatagramSocket serverSocket = new DatagramSocket(sport);
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);
        DataInputStream in = new DataInputStream(System.in);
        String s, t;
        while(true)
        {
            serverSocket.receive(dp);
            s = new String(dp.getData(), 0, dp.getLength());
            if(s.equals("STOP"))
            {
                break;
            }
            System.out.println("Client: " + s);
        }
    }
}