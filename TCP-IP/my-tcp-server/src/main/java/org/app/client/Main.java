package org.app.client;

import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8087);
        //socket.connect();
        String message = "Test";
        socket.getOutputStream().write(message.getBytes());

    }

}
