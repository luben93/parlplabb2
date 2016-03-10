package labb2.view;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import labb2.model.Shape;
import labb2.model.color;

/**
 * Created by luben on 2016-03-09.
 */
public class AttributesController extends Controller {

    @FXML
    private GridPane pane;
    @FXML
    private Label tool;

    @FXML
    private ColorPicker picker;


    @Override
    protected void initialize() {
        picker.setOnAction(event -> colorPicked());
    }


//
    private void colorPicked(){
        System.out.println("lucas "+picker.getValue());
        color c=color.colorFactory(picker.getValue());
//        c.execute();
//        Main.commands.push()
        main.attributeClicked(c);
    }


    @Override
    public void toolClicked(Shape a) {
        tool.setText(a.getName());
        //TODO show relevent attributes for prototype
    }
}
