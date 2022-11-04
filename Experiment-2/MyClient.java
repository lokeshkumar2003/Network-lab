import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyClient{
    public static void main(String[] arStrings) {
        try{
            Socket s = new Socket("localhost",6666);
            System.out.println("Enter DOB in (dd/mm/yyyy):");
            Scanner sc = new Scanner(System.in);
            String dob = sc.nextLine();
            DataOutputStream dis = new DataOutputStream(s.getOutputStream());
            dis.writeUTF(dob);
            dis.flush();
            dis.close();
            s.close();
            

        }
        catch(Exception e){

        }
    }
}