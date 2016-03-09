package labb2.model;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by luben on 2016-03-09.
 */
public class square extends shape {
    private int x;
    private int y;
    private int x2;
    private int y2;

    @Override
    public void execute(GraphicsContext con) {
        con.fillRect(x, y, x2, y2);

    }


    private square() {
        //dont come here
    }

    private square(point p, point s) {
        this.x = p.getX();
        this.y = p.getY();
        this.x2 = p.getX() + s.getX();
        this.y2 = p.getY() + s.getX();
    }


    public static square shapeFactory(point p, point next) {
        return new square(p, next);
    }
}
