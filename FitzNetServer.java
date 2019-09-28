import java.net.*;
import java.io.*;

public class FitzNetServer{
    final static int PORT = 5000;
    public static void main(String[] args)throws IOException{
        System.out.println("FitzNet Server v1.0");
        createSocket();

    }
    public static void createSocket() throws IOException{
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client Connected.");
        System.out.println(clientSocket.getInetAddress());
        serverSocket.close();
    }
}