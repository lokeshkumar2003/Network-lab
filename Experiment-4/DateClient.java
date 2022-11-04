import java.net.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
public class DateClient{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket ds = new DatagramSocket();

        System.out.println("Enter DOB in YYYY-MM-DD format: ");
        Scanner scanner = new Scanner(System.in);
        String DOB = scanner.nextLine();
        scanner.close();
     
        byte[] b = DOB.getBytes();

        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp = new DatagramPacket(b,b.length,ia,9999);
        ds.send(dp);

        byte[] b1 = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(b1,b1.length);
        ds.receive(dp1);

        String str = new String(dp1.getData(),0,dp1.getLength());
        System.out.println("Age : "+str);
    }
}