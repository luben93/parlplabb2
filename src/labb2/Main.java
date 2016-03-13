package labb2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import labb2.model.Command;
import labb2.model.PrototypesModule;
import labb2.model.Shape;
import labb2.view.*;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main extends Application {



    public static Stage primaryStage;
    private BorderPane rootLayout;
    private GridPane rigth;
    private CanvasController canvasController;
    private ToolsController toolsController;
    private MenyController  rootController;
    private AttributesController attributesController;
    public static Deque<Command> commands=new ArrayDeque<Command>();
//    private Stack<Canvas> commands = new Stack<>();

    final private FileChooser fileChooser = new FileChooser();

    public int getCurrentLayer() {
        return canvasController.getCurrentLayer();
    }

    public int getCanvasListSize() {
        return canvasController.getCanvasListSize();
    }


    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public void addCanvasLayer(Canvas l){
        toolsController.addSelectCommands(l);
    }

    public void removeLayer(Canvas l){
        toolsController.removeLayer(l);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("VectorDrawer");

        rootController=initRootLayout();
        PrototypesModule.init();


        canvasController=showDrawArea();
//        canvasController.attributeClicked((Command) PrototypesModule.findAndCloneAttributes("stroke", Color.BLACK.toString()));
//        canvasController.attributeClicked((Command) PrototypesModule.findAndCloneAttributes("fill", Color.BLACK.toString()));

        toolsController= (ToolsController) showArea("tools", 0);
        attributesController= (AttributesController) showArea("attributes", 1);
    }

    private Controller showArea(String path,int row) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/"+path+".fxml"));
            GridPane tools = (GridPane) loader.load();


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

    public void restore(int i){
        canvasController.restoreSave(i);
    }

    public void clicked(Shape a){
        canvasController.toolClicked(a);
        attributesController.toolClicked(a);
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
//            canvasController.test();
            return canvasController;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MenyController initRootLayout() {
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
            rootLayout.setRight(rigth);

            MenyController controller = loader.getController();
            controller.setMainApp(this);
            return controller;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        launch(args);
    }

    public Main() {

    }

    public void attributeClicked(Command c) {
        canvasController.attributeClicked(c);
    }

    public void resetAttributes(Shape tool) {
        attributesController.toolClicked(tool);
    }

    public void setCurrentLayer(Canvas currentLayer) {
//        this.currentLayer = currentLayer;
        canvasController.setCurrentLayer(currentLayer);
    }
}
