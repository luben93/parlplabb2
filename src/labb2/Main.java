package labb2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import labb2.view.Controller;

public class Main extends Application {

    private Controller c =null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/sample.fxml"));
        Parent root = loader.load();
//        Parent root = loader.load(getClass().getResource("view/sample.fxml"));
//        Parent root =  FXMLLoader.load(getClass().getResource("view/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        c = loader.getController();
//        System.out.println();
        c.setMainApp(this);
        System.out.println(c);
        c.setLabel("yo");

    }

    public void butt(){
        c.setLabel("bajs");
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Main(){

    }
}
