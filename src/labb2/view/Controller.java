package labb2.view;

import javafx.fxml.FXML;
import labb2.Main;
import labb2.model.Shape;

/**
 * Created by luben on 2016-03-09.
 */
public abstract class Controller {

     Main main;



    public void setMainApp(Main main) {
        this.main = main;
    }

    @FXML
    abstract void initialize();

    public abstract void toolClicked(Shape a);


}
