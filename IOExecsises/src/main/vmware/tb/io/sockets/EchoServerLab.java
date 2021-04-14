package main.vmware.tb.io.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerLab {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(12345);
             Socket client = serverSocket.accept();
             BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter writer = new PrintWriter(client.getOutputStream(), true)) {

            System.out.println("Client connected to server. ");

            while (true) {
                String clientMessage = reader.readLine();
                System.out.println(clientMessage);
                writer.println(clientMessage);
                if(clientMessage.equals("quit")) {
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
