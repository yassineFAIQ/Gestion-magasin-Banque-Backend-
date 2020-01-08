import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedList;

import Client.ClientThread;


public class Main {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Collection<Thread> clientsThreads = new LinkedList<>();
        int port = 50000;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started");

            while (true) {
                System.out.println("Waiting for new connection...");
                Socket newClientSocket = serverSocket.accept();
                new Thread(new ClientThread(newClientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
