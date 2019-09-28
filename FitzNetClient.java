import java.net.*;
import java.io.*;
import java.util.*;

public class FitzNetClient {
    static Socket socket;
    public static void main(String[] args)throws IOException{
        // Var declarations
        //This takes the localIP of the machine
        InetAddress host = InetAddress.getLocalHost();
        Scanner sysIn = new Scanner(System.in);
        Socket socket = null;
        ObjectInputStream obIn = null;
        ObjectOutputStream obOut = null;

        System.out.println("Fitz-Net Client Alpha 1.0");

        while(true){
        //Create Socket
        socket = new Socket(host.getHostName(),5000);
        //Use this to write to socket
        System.out.println("Starting OutputStream");
        obOut = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Attached");
        //Use this to recive messages from the Server
        System.out.println("Starting InStream.");
        obIn = new ObjectInputStream(socket.getInputStream());
        System.out.println("Attached");
        String message = "";
        System.out.println("Enter message to send to server");
        message = sysIn.nextLine();
        
        obOut.writeObject(message);
        
        //Cleaning House
        obOut.close();
        obIn.close();
        socket.close();

        }
    }

/*
Timer t = new Timer();
t.schedule(new TimerTask() {
    @Override
    public void run() {
       System.out.println("Hello World");
    }
}, 0, 5000);
*/
}