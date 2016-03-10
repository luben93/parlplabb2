package labb2.view;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import labb2.model.Point;
import labb2.model.PrototypesModule;
import labb2.model.Shape;

public class CanvasController extends Controller {

    @FXML
    private Canvas canvas;

    private Shape current = null;

    private Point start = null;


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
        Shape line = (Shape) PrototypesModule.findAndClone("line");
        Shape square = (Shape) PrototypesModule.findAndClone("square");
        Point mid = Point.pointFactory(30, 30);
        Point end = Point.pointFactory(60, 60);
        line.setStop(mid);
        square.setStart(mid);
        square.setStop(end);
        line.execute(gc);
        square.execute(gc);


    }

    private void mouseClicked(Point p) {
        System.out.println(p);
        if (current != null) {
            {
                if (start == null) {
                    System.out.println("started drawing");
                    start = p;
                    current.setStart(start);
                } else {
                    System.out.println("finished drawing");
                    current.setStop(p);
                    start = null;
                    current.execute(canvas.getGraphicsContext2D());
                }
            }
        }
    }


    public void toolClicked(Shape a) {
        current = a;
    }

    @Override
    protected void initialize() {
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> mouseClicked(Point.pointFactory((int) t.getX(), (int) t.getY())));
    }
}
