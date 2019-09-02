package server.api;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatConnector {
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private TextArea textArea;
    private StringProperty text = new SimpleStringProperty(this, "text","");

    public ChatConnector(TextArea textArea) {
        try {
            this.textArea=textArea;
            socket = new Socket("127.0.0.1",8087);
            in = socket.getInputStream();
            System.out.println(in);
            out = socket.getOutputStream();
            Thread.sleep(2000);
            //textArea.textProperty().bind(text);
            text.bind(textArea.textProperty());
            //textArea.textProperty().bind(text);

            //initServerEventThread().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(String message){
        try {
            out.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Thread initServerEventThread(){

        return  new Thread(){

            public void run(){
                while(true){
                    try {
                        int t = in.available();
                        if (t == -1) {
                            Thread.sleep(300);
                        }else{
                            byte[] data = new byte[in.available()];
                            in.read(data);
                            String mesageFromServer = new String(data);
                            System.out.println(mesageFromServer);
                            text.setValue(mesageFromServer);
                            //String oldText = textArea.getText();
                            //textArea.setText(mesageFromServer);

                            /*Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    textArea.appendText(mesageFromServer);
                                }
                            });*/

                        }

                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        };
    }
}
