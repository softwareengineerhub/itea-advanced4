package sample;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        StackPane stackPane = new StackPane();
        HBox controlPanel = new HBox(10);
        controlPanel.styleProperty().set("-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,red) (1.0,aqua);");
        //"-fx-background-color: linear (0%,0%) to (100%,100%) stops (0.0,aqua) (1.0,red);"


        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.setPadding(new Insets(50, 50, 50, 50));

        Node n1 = initControlNode("icon-0.png", new Runnable() {
            @Override
            public void run() {

                NumberAxis xAxis = new NumberAxis();
                NumberAxis yAxis = new NumberAxis();
                // график
                LineChart<Number, Number> chart = new LineChart<Number, Number>(xAxis, yAxis);
                chart.setTitle("Basic LineChart");
                xAxis.setLabel("X Axis");
                yAxis.setLabel("Y Axis");
                // набор случайных данных
                XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
                series.setName("Random Data");
                Random random = new Random();
                for (int i = 0; i < 10 + random.nextInt(20); i++) {
                    series.getData().add(new XYChart.Data<Number, Number>(10 * i + 5, random.nextDouble() * 120));
                }
                chart.getData().add(series);


                stackPane.getChildren().clear();
                stackPane.getChildren().addAll(chart);
           //     System.out.println("CLICK!!!!!");




            }
        });



        Node n2 = initControlNode("icon-1.png", new Runnable() {
            @Override
            public void run() {
                stackPane.getChildren().clear();
                stackPane.getChildren().addAll(new Button("ICON1"));
            }
        });
        Node n3 = initControlNode("icon-2.png", new Runnable() {
            @Override
            public void run() {

            }
        });
        Node n4 = initControlNode("icon-3.png", new Runnable() {
            @Override
            public void run() {

            }
        });
        Node n5 = initControlNode("icon-4.png", new Runnable() {
            @Override
            public void run() {

            }
        });
        controlPanel.getChildren().addAll(n1, n2, n3, n4, n5);




        root.setCenter(stackPane);
        root.setBottom(controlPanel);

        Scene scene = new Scene(root, 800, 450);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node initControlNode(String imgPath, Runnable clickTask){
        Image img = new Image(getClass().getResourceAsStream(imgPath));
        ImageView node = new ImageView(img);

        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clickTask.run();
            }
        });



        Reflection reflection = new Reflection();
        //reflection.seto
        node.setEffect(reflection);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.valueOf("300ms"), node);
        scaleTransition.setToX(1.3);
        scaleTransition.setToY(1.3);


        ScaleTransition scaleBackTransition = new ScaleTransition(Duration.valueOf("300ms"), node);
        scaleBackTransition.setToX(1);
        scaleBackTransition.setToY(1);


// при наведении курсора мы запускаем анимацию увеличения кнопки
        node.setOnMouseEntered(new EventHandler() {

            public void handle(Event event) {
                scaleTransition.playFromStart();
                scaleBackTransition.stop();
            }
        });
        // когда курсор сдвигается -- запускаем анимацию уменьшения
        node.setOnMouseExited(new EventHandler() {

            public void handle(Event event) {
                scaleTransition.stop();
                scaleBackTransition.playFromStart();
            }
        });


        /*node.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                effect.setInput(effectPressed);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(new KeyFrame(Duration.valueOf("300ms"), new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        effect.setInput(null);
                    }

                }));
                timeline.play();
                //final ColorAdjust effectPressed = new ColorAdjustBuilder().brightness(-0.5).build();
                action.run();
            }
        });*/


        //scaleTransition.play();
        //scaleBackTransition.play();



        return node;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
