package labb2.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import labb2.Main;
import labb2.model.Shape;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Desktop;
/**
 * Created by bulbatross on 2016-03-12.
 */
public class MenyController extends  Controller {

    final private FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();
    @FXML
    private MenuBar menuBar;

    @Override
    void initialize() {

    }
    @FXML
    void load (ActionEvent actionEvent) {
        File file = fileChooser.showOpenDialog(Main.primaryStage);
        if (file != null) {
            openFile(file);
        }
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
