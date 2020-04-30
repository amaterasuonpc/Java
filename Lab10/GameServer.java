package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GameServer {
    ServerSocket serverSocket = null;
    static boolean serverRunning = true;
    public void startServer() {
        try {
            serverSocket = new ServerSocket(666);
            serverSocket.setSoTimeout(4500);
            while (serverRunning) {
                System.out.println ("Waiting");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }

        } catch (IOException e ) {
            e.printStackTrace();
        }
        finally{
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void stopserver(){
        serverRunning= false;

    }
}
