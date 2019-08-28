package com.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread {
    private ServerSocket serverSocket;
    private List<Socket> clients = new ArrayList();

    public ServerThread() throws IOException {
        serverSocket = new ServerSocket(8087);

    }

    public void run(){
        System.out.println("#######SERVER START###########");
        while(true){
            try {
                Socket socket = serverSocket.accept();
                clients.add(socket);
                new ClientThread(socket, clients).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
