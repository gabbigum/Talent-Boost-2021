package main.vmware.tb.io.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {


        try (ServerSocket serverSocket = new ServerSocket(8000);
             Socket clientSocket = serverSocket.accept();
             BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                System.out.println("Message received from client: " + inputLine);
                out.println("Echo " + inputLine);
            }
        } catch (IOException e) {
            System.out.println("There is a problem with the server socket");
            e.printStackTrace();
        }
    }
}
