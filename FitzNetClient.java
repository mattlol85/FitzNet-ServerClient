import java.net.*;
import java.io.*;

public class FitzNetClient {
    static Socket socket;
    public static void main(String[] args)throws IOException{
        System.out.println("Fitz-Net Client Alpha 1.0");
        socket = new Socket("localhost",5000);
        DataInputStream dIn = new DataInputStream(socket.getInputStream());
        socket.close();
    }

}