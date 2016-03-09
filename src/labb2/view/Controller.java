package labb2.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import labb2.Main;

public class Controller {
    @FXML
    private Label hej;
    @FXML
    private Button buttButton;


    private Main main;

    @FXML
    private void initialize() {
        hej = new Label("hello wörld");
        hej.setText("hejsan");
        System.out.println("init");
    }


    @FXML
    private void button() {
        main.butt();
    }

    public void setMainApp(Main main) {
        this.main = main;
        hej.setText("halloj");
    }

    public void setLabel(String s) {
        System.out.println(s);
        buttButton.setText(s);
    }
}
