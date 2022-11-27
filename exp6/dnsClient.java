import java.util.*;
import java.io.*;
import java.net.*;

class dnsClient {
    public static void main(String args[]) throws Exception 
    {
        DatagramSocket client = new DatagramSocket();
        InetAddress ad = InetAddress.getLocalHost();
        DataInputStream in = new DataInputStream(System.in);
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);
        String s;
        System.out.println("Enter the IP address or the web-adress :");
        s = in.readLine();
        client.send(new DatagramPacket(s.getBytes(), s.length(), ad, 1309));
        client.receive(dp);
        String res = new String(dp.getData());
        System.out.println("The IP address or the webadress is :" + res);
        
    }
}