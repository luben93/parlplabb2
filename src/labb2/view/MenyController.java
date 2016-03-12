package labb2.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.stage.FileChooser;
import labb2.Main;
import labb2.model.Command;
import labb2.model.PrototypesModule;
import labb2.model.Shape;

import java.awt.*;
import java.io.*;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by bulbatross on 2016-03-12.
 */
public class MenyController extends Controller {
    //    private GraphicsContext gc;
    final private FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();
    @FXML
    private MenuBar menuBar;

    @Override
    void initialize() {

    }

    @FXML
    void load(ActionEvent actionEvent) {
        /*
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("SER", "*.ser")
        );
        File file = fileChooser.showOpenDialog(Main.primaryStage);
        if (file != null) {
            openFile(file);
        }
        */
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/picture.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Main.commands = (Deque<Command>) in.readObject();
            in.close();
            fileIn.close();
            //Main.commands.forEach(shape -> shape.execute(gc));
//            System.out.println(Main.commands.size());
//            Main.commands.forEach(System.out::println);
            Main.commands.push((Command) PrototypesModule.findAndClone("line"));
            main.undo();

        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Command class not found");
            c.printStackTrace();

        }
    }

    @FXML
    void save(ActionEvent actionEvent) {
        //FileChooser fileChooser = new FileChooser();
        //fileChooser.setTitle("Save Image");
        //System.out.println(Main.commands);
        //File file = fileChooser.showSaveDialog(Main.primaryStage);

        //if (file != null) {
            /*
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(pic.getImage(),
                        null), "png", file);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            */
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/picture.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Main.commands);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/picture.ser");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        //}

    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    MenyController.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }

    @Override
    public void toolClicked(Shape a) {

    }
/**
 * MenuItem cmItem2 = new MenuItem("Save Image");
 cmItem2.setOnAction(new EventHandler<ActionEvent>() {
 public void handle(ActionEvent e) {
 FileChooser fileChooser = new FileChooser();
 fileChooser.setTitle("Save Image");
 System.out.println(pic.getId());
 File file = fileChooser.showSaveDialog(stage);
 if (file != null) {
 try {
 ImageIO.write(SwingFXUtils.fromFXImage(pic.getImage(),
 null), "png", file);
 } catch (IOException ex) {
 System.out.println(ex.getMessage());
 }
 }
 }
 }
 );
 */

}
