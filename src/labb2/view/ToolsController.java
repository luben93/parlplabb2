package labb2.view;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import labb2.model.PrototypesModule;
import labb2.model.Shape;

/**
 * Created by luben on 2016-03-09.
 */
public class ToolsController extends Controller {
    @FXML
    private MenuButton shapes;


    @FXML
    @Override
    protected void initialize() {
        PrototypesModule.listShapeNames().forEach(s -> shapes.getItems().add(new MenuItem(s)));
        shapes.getItems().forEach(menuItem -> menuItem.setOnAction(event -> selected(menuItem.getText())));

    }

    @Override
    public void toolClicked(Shape a) {

    }

    private void selected(String o){
        main.clicked((Shape) PrototypesModule.findAndClone(o));
        shapes.setText(o);
    }

    @FXML
    private void select(){

    }

    @FXML
    private void undo(){
        main.undo();
    }

}
