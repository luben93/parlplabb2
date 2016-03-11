package labb2.view;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import labb2.Main;
import labb2.model.*;

public class CanvasController extends Controller {

    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private Shape current = null;
    private Point start = null;


    public void test() {

        Shape line = (Shape) PrototypesModule.findAndClone("line");
        Shape square = (Shape) PrototypesModule.findAndClone("square");
        Point zero = Point.pointFactory(0, 0);
        Point mid = Point.pointFactory(30, 30);
        Point end = Point.pointFactory(60, 60);
        line.setStart(zero);
        line.setStop(mid);
        square.setStart(mid);
        square.setStop(end);
        line.execute(gc);
        square.execute(gc);


    }

    public void undoLast() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if (!Main.commands.empty()) {
            Command last = Main.commands.pop();//TODO last set to current??
            System.out.println("pop " + last);
            Main.commands.forEach(shape -> shape.execute(gc));
        }
    }

    private void mouseClicked(Point p) {
        System.out.println(p);
        if (current != null) {
            if (start == null) {
                start = p;
                current.setStart(start);
            } else {
                current.setStop(p);
                current.execute(gc);
                Main.commands.push(current);
                start = null;
                current= (Shape) current.clone();
            }
        }
    }


    public void toolClicked(Shape a) {
        current = a;
    }

    @Override
    protected void initialize() {
        gc = canvas.getGraphicsContext2D();
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> mouseClicked(Point.pointFactory((int) t.getX(), (int) t.getY())));
    }

    public void attributeClicked(Command c) {
        c.execute(gc);
        Main.commands.push(c);
    }
}
