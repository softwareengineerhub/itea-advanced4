package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Person person = new Person();
        //StackPane root = new StackPane();

        VBox vBox = new VBox(10);
        BorderPane root = new BorderPane();
        root.setCenter(vBox);
        //HBox root = new HBox(10);



        TextField aField = new TextField();
        TextField bField = new TextField();
        TextField resField = new TextField();
        Button btn = new Button("Add");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String aVal = aField.getText();
                String bVal = bField.getText();
                int a = Integer.parseInt(aVal);
                int b = Integer.parseInt(bVal);
                int res = a+b;
                resField.setText(res+"");
                person.setName("Name"+res);
            }
        });



        vBox.getChildren().add(btn);
        vBox.getChildren().addAll(aField, bField, resField);
        Label label = new Label("Person Name: ");
        vBox.getChildren().addAll(label);
        label.textProperty().bind(person.nameProperty());




        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
