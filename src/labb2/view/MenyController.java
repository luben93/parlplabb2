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
    final private FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();
    @FXML
    private MenuBar menuBar;

    @Override
    void initialize() {

    }

    @FXML
    void load(ActionEvent actionEvent) {

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("SER", "*.ser")
        );
        File file = fileChooser.showOpenDialog(Main.primaryStage);
        try {

            FileInputStream fileIn = new FileInputStream(file.getPath());
            ObjectInputStream in = new ObjectInputStream(fileIn);
            int i = in.readInt();
            Main.commands = (Deque<Command>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println(Main.commands.size());
            Main.commands.forEach(System.out::println);
            Main.commands.push((Command) PrototypesModule.findAndClone("line"));
            main.restore(i);

        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Command class not found");
            c.printStackTrace();

        }
    }

    @FXML
    void save(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        //Set extension filter
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("SER", "*.ser")
        );

        File file = fileChooser.showSaveDialog(Main.primaryStage);

        if (file != null) {

            SaveFile(main.getCanvasListSize(),Main.commands, file);

        }

    }

    private void SaveFile(int i,Deque<Command> commands, File file){
        try
        {
            //FileOutputStream fos = new FileOutputStream("tempdata.ser");
            FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(i);
            oos.writeObject(commands);
            oos.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(
                    MenyController.class.getName()).log(
                    Level.SEVERE, null, ex
            );
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

}
