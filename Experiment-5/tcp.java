import java.net.*;
import java.io.*;
import java.util.*;   
public class tcp{
    public static void main(String[] args) throws Exception
    {
        Random rand = new Random();
        int seq[] = new int[8];
        int ack[] = new int[8];
        seq[0] = rand.nextInt(1000);
        seq[1] = rand.nextInt(1000);
        ack[0] = 0;
        for(int i=0; i<seq.length; i++){
            if (i==1 ){
                ack[i] = seq[i-1]+1;
            }
            else if(i!=0){
                ack[i] = seq[i-1]+1;
                seq[i] = ack[i-1];
            }
            System.out.println("Seq : "+Integer.toString(seq[i]) +"      Ack : "+ Integer.toString(ack[i]));
        }
    }
}