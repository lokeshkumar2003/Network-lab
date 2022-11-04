import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.Math;   

public class client1 {
public static void main(String[] args){
try{
ServerSocket ss=new ServerSocket(6666);
Socket s=ss.accept();
DataInputStream dis=new DataInputStream(s.getInputStream());
String location=(String)dis.readUTF();
int i = (int)(Math.random()*(1000-0+1)+0);
String destination = "C:\\Users\\lokes\\OneDrive\\Desktop\\amrita\\3\\5 sem\\19cse301\\lab\\Experiment-3\\"+i+".jpg";
Path src = Paths.get(location); 
Path dest = Paths.get(destination);
Files.copy(src, dest);
System.out.println("Check for file image_copy"+i+".jpg");
ss.close();
}catch(Exception e){System.out.println(e);}
}
}