package com.app;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.List;

public class ClientThread extends Thread {
    private Socket client;
    private List<Socket> clients;

    public ClientThread(Socket client, List<Socket> clients) {
        this.client = client;
        this.clients=clients;
    }

    public void run(){
            try {
                InputStream in = client.getInputStream();
                System.out.println("Crete new client");
                while(true) {
                    int res = in.read();
                    if(res!=-1){
                        String message = readClientData(in);
                        System.out.println(message);
                        for(Socket socket: clients){
                            socket.getOutputStream().write(message.getBytes());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    private String readClientData(InputStream in){
        try {
            byte[] data = new byte[in.available()];
            in.read(data);
            return new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
