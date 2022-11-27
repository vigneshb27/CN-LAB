import java.util.*;
import java.net.*;
import java.io.*;

class UDPChatClient{
    public static void main(String args[]) throws Exception
    {
        int cport = 789;
        int sport = 780;
        DatagramSocket clientSocket = new DatagramSocket(cport);
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);
        DataInputStream in = new DataInputStream(System.in);
        String s, t;
        InetAddress ad = InetAddress.getLocalHost();
        while(true)
        {
            s = in.readLine();

            clientSocket.send(new DatagramPacket(s.getBytes(), s.length(), ad, sport));
            if(s.equals("STOP"))
            {
                break;
            }
           
            clientSocket.receive(dp);
            t = new String(dp.getData(), 0, dp.getLength());
            if(t.equals("STOP"))
            {
                break;
            }
            else
            {
                System.out.println("Server : " + t);
            }
        }
    }
}