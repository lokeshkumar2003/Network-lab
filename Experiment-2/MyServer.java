import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyServer{
    public static void main(String[] arStrings) {
        try{
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String dob = (String) dis.readUTF();
            Date d = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
            long diff = (new Date()).getTime() - d.getTime();
            long yrs = diff/(1000l * 60 * 60 * 24 * 365);
            long days = (diff/(1000l * 60 * 60 * 24 ))% 365;
            long month = days/30;
            days = days - (month*30);
            System.out.println("years : "+yrs+" monthth : "+month+" days : "+days );
            ss.close();
        }
        catch(Exception e){
        }
    }
}