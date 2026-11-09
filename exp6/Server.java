import java.net.*;

public class Server{
  public static void main (String args[]) throws Exception{
    DatagramSocket ss=new DatagramSocket(5000);
    System.out.println ("Server Started...");
    byte[] b=new byte[1024];
    DatagramPacket receiveP=new DatagramPacket(b, b.length);
    ss.receive (receiveP);

    String msg=new String(receiveP.getData(), 0, receiveP.getLength());

    msg = msg.replaceAll ("\\btbh\\b", "to be honest");
    msg = msg.replaceAll ("\\bidk\\b", "i dont know");
    msg = msg.replaceAll ("\\blol\\b", "laugh out loud");
    msg = msg.replaceAll ("\\big\\b", "i guess");

    byte[] data=msg.getBytes();
    DatagramPacket sendData =new DatagramPacket(data, data.length, receiveP.getAddress(), receiveP.getPort());
    ss.send(sendData);

    ss.close();
  }
}
