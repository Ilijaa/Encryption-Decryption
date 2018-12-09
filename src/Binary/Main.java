package Binary;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Enc/Dec");

        VBox input = new VBox(10);
        TextField inputmess = new TextField();

        inputmess.setPrefSize(700,200);
        input.getChildren().addAll(inputmess);


        Button enc= new Button("ENC");
        Button dec= new Button("DEC");
        HBox btns = new HBox(500);
        btns.getChildren().addAll(enc,dec);

        VBox output = new VBox(10);
        TextArea outputmess = new TextArea();

        outputmess.setPrefSize(700,200);
        outputmess.setWrapText(true);
        outputmess.setPrefColumnCount(50);
        output.getChildren().addAll(outputmess);


        VBox master = new VBox(10);
        master.getChildren().addAll(input, btns, output);
        Scene scene = new Scene(master,700,900);
        primaryStage.setScene(scene);
        primaryStage.show();

        enc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Encrypt encMess = new Encrypt(inputmess.getText(), inputmess.getText().length());
                outputmess.setText(encMess.toString());
            }
        });
        dec.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Decrypt decMess = new Decrypt(inputmess.getText(), inputmess.getText().length()/4);

                outputmess.setText(decMess.toString());

            }
        });
    }


    }

