import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class client {

  public static void main(String[] args) {
    try {
   Socket s = new Socket("localhost", 6666);

    System.out.println("Enter the file Name: ");
    Scanner scanner = new Scanner(System.in);
    String file_name = scanner.nextLine();

    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
     
    dout.writeUTF(file_name);

    dout.flush();
    dout.close();
    s.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}