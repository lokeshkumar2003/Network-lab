import java.io.*;
import java.net.*;
import java.util.Scanner;

public class server {

  public static void main(String[] args) {
    try {
      ServerSocket ss = new ServerSocket(6666);
      Socket s = ss.accept(); 
      DataInputStream dis = new DataInputStream(s.getInputStream());
      
      System.out.println("Reading the data.....");
      String str = (String) dis.readUTF();
      String p = "C:\\Users\\lokes\\OneDrive\\Desktop\\amrita\\3\\5 sem\\19cse301\\lab\\Experiment-3\\" ;
      String path = p.concat(str);
      
      File tempFile = new File(path);
      boolean exists = tempFile.exists();

      if(exists){
        Scanner sc = new Scanner(tempFile);
        sc.useDelimiter("\\Z");
       System.out.println(sc.next());
       //System.out.println("jpg file named "+tempFile+" is recived");
      }
      else{
        System.out.println("File Does Not Exists!!");
      }
      ss.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}