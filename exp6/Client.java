import java.net.*;
import java.util.*;

public class Client{
  public static void main (String args[]) throws Exception{

    DatagramSocket ss=new DatagramSocket();
    Scanner sc=new Scanner(System.in);
    System.out.println ("Enter the string: ");
    String msg= sc.nextLine();
    byte[] data= msg.getBytes();
    DatagramPacket sendData=new DatagramPacket (data, data.length(), InetAddress.getByName("localhost"), 5000);
    ss.send(sendData);

    byte[] b=new Byte[1024];
    DatagramPacket recieveData=new DatagramPacket(b, b.length);
    ss.receive(receiveData);

    ss.close();
    sc.close();
  }
}
