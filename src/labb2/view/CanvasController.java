package labb2.view;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import labb2.model.point;
import labb2.model2.PrototypesModule;
import labb2.model2.Shape;

public class CanvasController extends Controller {

    @FXML
    private Canvas canvas;


    //TODO add every execute command to stack

    //TODO when undo is pushed pop stack, empty canvas, foreach command left in stack execute


    public void test() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
//TODO testing
//        gc.setFill(Color.BLUE);
//        gc.fillRect(75, 75, 100, 100);

//        gc.beginPath();
//        gc.lineTo(10, 10);
//        gc.lineTo(20, 20);
//        gc.closePath();
//
//        gc.strokeLine(30, 10, 20, 20);

//        line.shapeFactory(pointFactory(10,10), pointFactory(50,50)).execute(gc);
//        square.shapeFactory(pointFactory(70,70), pointFactory(5,5)).execute(gc);


        PrototypesModule.init();
        Shape line= (Shape) PrototypesModule.findAndClone("line");
        Shape square= (Shape) PrototypesModule.findAndClone("square");
        point mid=point.pointFactory(30,30);
        point end=point.pointFactory(60,60);
        line.setStop(mid);
        square.setStart(mid);
        square.setStop(end);
        line.execute(gc);
        square.execute(gc);


    }

}
