package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    int port;
    String serverAddress = "127.0.0.1";
    static boolean isRunning = true;

    public GameClient(int port) {
        this.port = port;
    }

    public void startClient() {

        try {
            Socket socket = new Socket(serverAddress, port);

            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));


            while (isRunning) {
                Scanner scanner = new Scanner(System.in);
                String inputString = scanner.nextLine();
                if (inputString.equals("exit")) {
                    socket.close();
                    System.exit(1);

                }

                out.println(inputString);

                String response = in.readLine();
                System.out.println(response);
            }

        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
