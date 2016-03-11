package labb2.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by luben on 2016-03-09.
 */
interface Prototype {
    Object clone();

    String getName();
}

class Fill extends Attributes {
    private Color color;

    @Override
    public void execute(GraphicsContext con) {
        con.setFill(color);
    }

    @Override
    public Object clone() {
        return Fill.attributeFactory(color);
    }

    @Override
    public void setAttrbute(Object o) {
        if (o instanceof Color) {
            color = (Color) o;
        }

    }


    public static Attributes attributeFactory(Object o) {
        Fill tmp = new Fill();
        tmp.setAttrbute(o);
        return tmp;

    }

    @Override
    public String getName() {
        return "fill";
    }
}


class Stroke extends Attributes {
    private Color color;

    @Override
    public void execute(GraphicsContext con) {
        con.setStroke(color);
    }

    @Override
    public Object clone() {
        return Stroke.attributeFactory(color);
    }

    @Override
    public void setAttrbute(Object o) {
        if (o instanceof Color) {
            color = (Color) o;
        }
    }


    public static Attributes attributeFactory(Object o) {
        Stroke tmp = new Stroke();
        tmp.setAttrbute(o);
        return tmp;
    }

    @Override
    public String getName() {
        return "stroke";
    }
}

class Square extends Shape {
    Square(Point start, Point stop) {
        super(start, stop);
        getAttributes().add("fill");

    }

    public Object clone() {
        return new Square(start, stop);
    }

    public String getName() {
        return "square";
    }

    public void execute(GraphicsContext con) {
        int xStop = stop.getX();//Math.abs(stop.getX() - start.getX());
        int yStop = stop.getY();//Math.abs(stop.getY() - start.getY());
        int xStart = start.getX();
        int yStart = start.getY();
        if (xStop < xStart) {
            int tmp = xStart;
            xStart = xStop;
            xStop = tmp;
        }
        if (yStop < yStart) {
            int tmp = yStart;
            yStart = yStop;
            yStop = tmp;
        }
        xStop = Math.abs(xStop - xStart);
        yStop = Math.abs(yStop - yStart);
        con.fillRect(xStart, yStart, xStop, yStop);
    }
}

class Line extends Shape {
    Line(Point start, Point stop) {
        super(start, stop);
        getAttributes().add("stroke");
    }

    public Object clone() {
        System.out.printf("clone");
        return new Line(start, stop);
    }

    public String getName() {
        return "line";
    }

    public void execute(GraphicsContext con) {
        con.strokeLine(start.getX(), start.getY(), stop.getX(), stop.getY());
//        System.out.println(this+" "+con);
//        System.out.println("lien: execute");
    }

}


public class PrototypeDemo {
    // 3. Populate the "registry"
    public static void initializePrototypes() {
        Point zero = Point.pointFactory(0, 0);
        PrototypesModule.addPrototype(new Line(zero, zero));
        PrototypesModule.addPrototype(new Square(zero, zero));
        PrototypesModule.addPrototype(new Fill());
        PrototypesModule.addPrototype(new Stroke());
    }

}