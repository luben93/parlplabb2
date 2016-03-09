package labb2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import labb2.view.Controller;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private GridPane rigth;
//    private Controller c =null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("VectorDrawer");

        initRootLayout();

        showDrawArea();
        showToolArea();
        showAtributesArea();
    }

    private void showToolArea() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/tools.fxml"));
            GridPane tools = (GridPane) loader.load();

            // Set person overview into the center of root layout.
            rigth.add(tools,0,0);
            // Give the controller access to the main app.
            Controller controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showAtributesArea() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/attributes.fxml"));
            GridPane atributes = (GridPane) loader.load();

            // Set person overview into the center of root layout.
            rigth.add(new Separator(Orientation.HORIZONTAL),0,1);
            rigth.add(atributes,0,2);
            // Give the controller access to the main app.
            Controller controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showDrawArea() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/sample.fxml"));
            GridPane personOverview = (GridPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            // Give the controller access to the main app.
            Controller controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/root.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            rigth=new GridPane();
            rootLayout.setRight(rigth);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public void butt(){
//        c.setLabel("bajs");
//    }

    public static void main(String[] args) {
        launch(args);
    }

    public Main() {

    }
}
