package main.vmware.tb.io.sockets;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientLab {
    public static void main(String[] args) {


        try (Socket socket = new Socket("localhost", 12345);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("(client) Connecting..");

            while(true) {
                String in = scanner.nextLine();

                if(in.equals("quit")) {
                    break;
                }

                printWriter.println(in);
                String reply = reader.readLine();
                System.out.println(reply);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
