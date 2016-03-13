package labb2.view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import labb2.model.Command;
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


    private int row = 1;


    @Override
    protected void initialize() {
        pane = new GridPane();
    }

    private void addAttribute(String s) {
        switch (s) {
            case "fill":
            case "stroke": {
                ColorPicker attribute = new ColorPicker();//TODO check attribute object/tool type??

//        System.out.printf("hej");
                attribute.setOnAction(event -> main.attributeClicked((attributes) PrototypesModule.findAndCloneAttributes(s, attribute.getValue().toString())));
                attribute.setValue(Color.BLACK);
                pane.addRow(row++, new Label(s), new Label(" "), attribute);
                break;
            }
            case "linewidth": {
                Slider attribute = new Slider(0, 10, 1);
                attribute.valueProperty().addListener((observable, oldValue, newValue) -> main.attributeClicked((attributes) PrototypesModule.findAndCloneAttributes(s, newValue.toString())));
                pane.addRow(row++, new Label(s), new Label(" "), attribute);

                break;
            }
            case "setfill":{
                ChoiceBox<String> attribute = new ChoiceBox<String>();
                attribute.getItems().addAll("fill","stroke");
//                attribute.setOnAction(event ->  Main.commands.remove(Main.commands.stream().filter(command -> command.getName().equals(s)).filter(command1 -> command1.getLayer()==main.getCurrentLayer()).findFirst().orElse(returnNullAndSetFill())));
//                attribute.setOnAction(event ->  Main.commands.remove(Main.commands.stream().filter(command -> command.getName().equals(s)).filter(command1 -> command1.getLayer()==main.getCurrentLayer()).findFirst().orElse(returnNullAndSetFill())));
                attribute.setOnAction(event -> main.attributeClicked((attributes) PrototypesModule.findAndCloneAttributes(s, attribute.getValue())));

                pane.addRow(row++, new Label("stroke or fill"), new Label(" "), attribute);

            }
            default:
//                System.err.println("oops");
                break;
        }

    }

    private Command returnNullAndSetFill(){
        main.attributeClicked((attributes) PrototypesModule.findAndCloneAttributes("setfill",""));
        return null;
    }


    @Override
    public void toolClicked(Shape a) {
        anchorPane.getChildren().removeAll(pane);
        pane = new GridPane();
        anchorPane.getChildren().add(pane);
        pane.addRow(0,new Label("attributes"),new Label("   "),tool);
        tool.setText(a.getName());
        a.getAttributes().forEach(s -> addAttribute(s));
    }
}
