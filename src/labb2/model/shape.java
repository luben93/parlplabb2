package labb2.model;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by luben on 2016-03-09.
 */
public abstract class shape implements drawable {
    public static shape shapeFactory(point p, point s) {
        return new shape() {
            @Override
            public void execute(GraphicsContext con) {
                System.err.println("executed abstract, error");
            }
        };
    }
}
