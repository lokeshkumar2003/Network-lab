import java.net.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class DateServer{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket ds = new DatagramSocket(9999);

        byte[] b1 = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b1,b1.length);
        ds.receive(dp);


        String DOB = new String(dp.getData(),0,dp.getLength());
        System.out.println("DATE OF BIRTH : "+DOB);

        LocalDate dateofbirth = LocalDate.parse(DOB);

        LocalDate curDate = LocalDate.now(); // get current date

        // convert date elements to string to send to the server
        String years = Integer.toString(Period.between(dateofbirth, curDate).getYears());
        String mon = Integer.toString(Period.between(dateofbirth, curDate).getMonths());
        String day = Integer.toString(Period.between(dateofbirth, curDate).getDays());

        String age = years + "Years " + mon + "months " + day + "days.";
        byte[] b2 = String.valueOf(age).getBytes();
        
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp1 = new DatagramPacket(b2,b2.length,ia,dp.getPort());
        ds.send(dp1);
    }
}