package com.company;

import javax.security.auth.callback.TextInputCallback;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    public Socket socket =null;
    static public boolean isrunning=true;
    public void run(){
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            while(isrunning) {
                String request = in.readLine();
                System.out.println(request);
                if (request.equals("stop-server")) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    String reply = "Shutting down the server";
                    out.println(reply);
                    out.flush();
                    GameServer.stopserver();
                    socket.close();
                    System.exit(1);
                }

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String reply = "Server received the request " + request;
                out.println(reply);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ClientThread(Socket socket) {
        this.socket = socket;
    }
}
