package labb2.view;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import labb2.model.PrototypesModule;
import labb2.model.Shape;
import labb2.model.attributes;


/**
 * Created by luben on 2016-03-09.
 */
public class AttributesController extends Controller {

    @FXML
    private GridPane pane;
    @FXML
    private Label tool;
    @FXML
    private AnchorPane anchorPane;


    private int row=1;


    @Override
    protected void initialize() {
        pane=new GridPane();
    }

    private void addAttribute(String s){
        ColorPicker attribute=new ColorPicker();//TODO check attribute object/tool type??
        pane.addRow( row++,new Label(s),attribute);
//        System.out.printf("hej");
        attribute.setOnAction(event -> main.attributeClicked( (attributes) PrototypesModule.findAndCloneAttributes(s,attribute.getValue())));
        attribute.setValue(Color.BLACK);
    }

    @Override
    public void toolClicked(Shape a) {
        anchorPane.getChildren().removeAll(pane);
        pane=new GridPane();
        anchorPane.getChildren().add(pane);
        tool.setText(a.getName());
        a.getAttributes().forEach(s -> addAttribute(s));
    }
}
