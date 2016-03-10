package labb2.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by luben on 2016-03-11.
 */
public class color implements Command {
    private Color color;

    @Override
    public void execute(GraphicsContext con) {
        if (color != null) {
            con.setFill(color);
            System.out.println("execute color" + color);
            con.setStroke(color);
        }//else error???
    }

    public static color colorFactory(Color c) {
        color tmp = new color();
        tmp.color = c;
        return tmp;
    }

}
