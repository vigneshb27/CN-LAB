import java.util.*;
import java.net.*;
import java.io.*;

class UDPEchoClient{
    public static void main(String args[]) throws Exception
    {
        int cport = 789;
        int sport = 780;
        DatagramSocket clientSocket = new DatagramSocket(cport);
        byte[] data = new byte[1024];
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
           
        }
    }
}