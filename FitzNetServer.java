import java.net.*;
import java.io.*;

public class FitzNetServer{
    private static ServerSocket server;
    private static int PORT = 5000;
    public static void main(String[] args)throws IOException{
        System.out.println("FitzNet Server v1.0");
        //Create ServerSocket obj
        server = new ServerSocket(PORT);
        //Always listening...

        while(true){
            System.out.println("Waiting for connection.");
            //Create socket and wait for client to connect
            Socket socket = server.accept();
            System.out.println(socket.getInetAddress() + " Connected !");
            //Take the sockets input stream (from client)
            System.out.println("Starting InStream.");
            DataInputStream obIn = new DataInputStream(socket.getInputStream());
            //Sending info back to client
            System.out.println("Starting OutputStream");
            DataOutputStream obOut = new DataOutputStream(socket.getOutputStream());
            //Convert ObjectInputStream to strings
            String message = (String) obIn.readUTF();
            System.out.println("Client: " + message);

            //Cleaning House
            obIn.close();
            socket.close();
        }
    }
}