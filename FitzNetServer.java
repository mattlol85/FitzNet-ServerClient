import java.net.*;
import java.io.*;
import java.util.*;

public class FitzNetServer {
    private static ServerSocket server;
    private static int PORT = 5000;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("FitzNet Server v1.0");
        // Create ServerSocket obj
        server = new ServerSocket(PORT);
        // Always listening...

        while (true) {
            try {
                System.out.println("Waiting for connection.");
                // Create socket and wait for client to connect
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress() + " Connected !");
                ObjectOutputStream obOut = new ObjectOutputStream(socket.getOutputStream());
                // Take the sockets input stream (from client)
                ObjectInputStream obIn = new ObjectInputStream(socket.getInputStream());
                // Send a message to client saying its connected
                obOut.writeObject("Connected.");
                obOut.flush();
                // Print out String of object
                System.out.println((String) obIn.readObject());

                String message = "";
                // Read the message from the client and print
                message += (String) obIn.readObject();
                System.out.println("Client: " + message);

                // Cleaning House
                obIn.close();
                obOut.close();
                socket.close();
            } catch (EOFException exception) {
                System.out.println("Client disconnect.");
                System.out.println();
            }
        }
    }
}