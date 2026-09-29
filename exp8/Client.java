import java.net.*;

public class Client{
    public static void main(String args[]) throws Exception{
        DatagramSocket ss=new DatagramSocket();

        byte[] b = "TIME".getBytes();

        ss.send (new DatagramPacket (b, b.length, InetAddress.getByName("localhost"), 5000));

        byte[] time=new byte[1024];
        DatagramPacket p=new DatagramPacket(time, time.length);
        ss.receive(p);

        String ctime = new String(p.getData(), 0, p.getLength());
        System.out.println (ctime + "is the current time");

        ss.close();

    }
}