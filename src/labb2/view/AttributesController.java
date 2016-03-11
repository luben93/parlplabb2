package labb2.view;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import labb2.model.*;

/**
 * Created by luben on 2016-03-09.
 */
public class AttributesController extends Controller {

    @FXML
    private GridPane pane;
    @FXML
    private Label tool;


    private int row=1;
//    private ColorPicker fill;
//    private ColorPicker stroke;


    @Override
    protected void initialize() {
    }

    private void addAttribute(String s){
        ColorPicker attribute=new ColorPicker();
        pane.addRow( row++,new Label(s),attribute);
        System.out.printf("hej");
        attribute.setOnAction(event -> main.attributeClicked( (Attributes) PrototypesModule.findAndCloneAttributes(s,attribute)));
    }

    @Override
    public void toolClicked(Shape a) {

        tool.setText(a.getName());
        //TODO show relevent attributes for prototype
        a.getAttributes().forEach(s -> addAttribute(s));
    }
}
