package labb2.model;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by luben on 2016-03-09.
 */
public class line extends shape {
    private int x;
    private int y;
    private int x2;
    private int y2;


    @Override
    public void execute(GraphicsContext con) {
        con.strokeLine(x, y, x2, y2);
    }

    private line() {
        //DONT come here
    }

    private line(point p, point s) {
        this.x = p.getX();
        this.y = p.getY();
        this.x2 = p.getX() + s.getX();
        this.y2 = p.getY() + s.getX();
    }


    public static line shapeFactory(point p, point next) {
        return new line(p, next);
    }
}
