package labb2.view;

import javafx.fxml.FXML;
import labb2.Main;

/**
 * Created by luben on 2016-03-09.
 */
public abstract class Controller {

     Main main;
//
//    @FXML
//    private void initialize() {
//
//    }

    public void setMainApp(Main main) {
        this.main = main;
    }

    @FXML
    protected abstract void initialize();
}
