package labb2.view;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasController extends Controller {

    @FXML
    private Canvas canvas;


    public void test() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
//TODO testing
        gc.setFill(Color.BLUE);
        gc.fillRect(75, 75, 100, 100);

        gc.beginPath();
        gc.lineTo(10, 10);
        gc.lineTo(20, 20);
        gc.closePath();

        gc.strokeLine(30, 10, 20, 20);
    }

}
