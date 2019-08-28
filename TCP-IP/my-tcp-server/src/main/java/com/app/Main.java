package com.app;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerThread st = new ServerThread();
        st.start();

    }
}
