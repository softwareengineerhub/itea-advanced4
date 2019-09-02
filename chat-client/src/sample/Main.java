package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import server.api.ChatConnector;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);


        TextArea textArea = new TextArea();
        root.getChildren().addAll(textArea);

        TextField userContent = new TextField();
        Button sendButton = new Button(">>>");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(userContent, sendButton);

        root.getChildren().addAll(hBox);
        ChatConnector chatConnector = new ChatConnector(textArea);

        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chatConnector.send(userContent.getText());
                System.out.println(userContent.getText());
            }
        });


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        textArea.appendText("11111");



    }


    public static void main(String[] args) {
        launch(args);
    }
}
