package labb2.view;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import labb2.model2.PrototypesModule;

/**
 * Created by luben on 2016-03-09.
 */
public class ToolsController extends Controller {
    @FXML
    private MenuButton shapes;


    @FXML
    @Override
    protected void initialize() {
        for (String o : PrototypesModule.listNames()) {
            MenuItem m = new MenuItem(o);
            m.setOnAction(e -> main.clicked(PrototypesModule.findAndClone(o)));
            shapes.getItems().add(m);
        }
    }

}
