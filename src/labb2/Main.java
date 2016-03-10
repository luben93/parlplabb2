package labb2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import labb2.model.Shape;
import labb2.view.AttributesController;
import labb2.view.CanvasController;
import labb2.view.Controller;
import labb2.view.ToolsController;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private GridPane rigth;
//    private List<Controller> controllers=new ArrayList<>();
    private CanvasController canvasController;
    private ToolsController toolsController;
    private AttributesController attributesController;




    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("VectorDrawer");

        initRootLayout();

        canvasController=showDrawArea();
        toolsController= (ToolsController) showArea("tools", 0);
        attributesController= (AttributesController) showArea("attributes", 1);
    }

    private Controller showArea(String path,int row) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/"+path+".fxml"));
            GridPane tools = (GridPane) loader.load();

            // Set person overview into the center of root layout.
            rigth.add(tools, 0, row);
            // Give the controller access to the main app.
            Controller controller = loader.getController();
            controller.setMainApp(this);
            return controller;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void undo(){
        canvasController.undoLast();
    }

    public void clicked(Shape a){
        canvasController.toolClicked(a);
        attributesController.toolClicked(a);
//        controllers.forEach(controller -> controller.toolClicked(a));
    }

    private CanvasController showDrawArea() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/sample.fxml"));
            GridPane personOverview = (GridPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            // Give the controller access to the main app.
            CanvasController canvasController = loader.getController();
            canvasController.setMainApp(this);
            canvasController.test();
            return canvasController;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

            rigth = new GridPane();
//            GridPane tmp = new GridPane();
//            tmp.add(new Separator(Orientation.VERTICAL), 0, 0);
//            tmp.add(rigth, 1, 0);
            rootLayout.setRight(rigth);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public Main() {

    }
}
