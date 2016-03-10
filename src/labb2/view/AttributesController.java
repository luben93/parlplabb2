package labb2.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import labb2.model.Shape;

/**
 * Created by luben on 2016-03-09.
 */
public class AttributesController extends Controller {

    @FXML
    private GridPane pane;
    @FXML
    private Label tool;

    @Override
    protected void initialize() {

    }

    @Override
    public void toolClicked(Shape a) {
        tool.setText(a.toString());
    }
}
