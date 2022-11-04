import java.io.*;
import java.net.*;
import java.util.*;

public class server1 {
public static void main(String[] args) {
     
    try{
    try (Scanner sc = new Scanner(System.in)) {
        System.out.print("Enter the file name: ");
        String loc= sc.nextLine();  
        Socket s=new Socket("localhost",6666);
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        dout.writeUTF("C:\\Users\\lokes\\OneDrive\\Desktop\\amrita\\3\\5 sem\\19cse301\\lab\\Experiment-3\\"+loc);
        dout.flush();
        dout.close();
        s.close();
    }
    }catch(Exception e){System.out.println(e);}
}
}