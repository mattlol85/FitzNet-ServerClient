import java.net.*;
import java.io.*;
import java.util.*;

public class FitzNetClient {
    static Socket socket;
    private static ObjectInputStream obIn = null;

    public static void main(String[] args) throws IOException,ClassNotFoundException,OptionalDataException{
        // Var declarations
        // This takes the localIP of the machine
        InetAddress host = InetAddress.getLocalHost();
        Scanner sysIn = new Scanner(System.in);
        Socket socket = null;
        ObjectOutputStream obOut = null;

        System.out.println("Fitz-Net Client Alpha 1.0");

        while (true) {
            try {
                // Create Socket
                socket = new Socket(host.getHostName(), 5000);
                // Connect Streams to server
                obOut = new ObjectOutputStream(socket.getOutputStream());
                obIn = new ObjectInputStream(socket.getInputStream());
                System.out.println((String)obIn.readObject());
                //Send Message/Data to server
                String message = "";
                System.out.println("Enter message to send to server");
                message = sysIn.nextLine();
                //Write to outstream
                obOut.writeObject(message);
                obOut.flush();

                // Cleaning House
                sysIn.close();
                obOut.close();
                obIn.close();
                socket.close();
            //Catch exceptions
            } catch (ConnectException e) {
                System.out.println(e.getMessage());
        }
    }

}
}