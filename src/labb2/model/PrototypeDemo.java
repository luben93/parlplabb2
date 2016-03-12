package labb2.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.List;

/**
 * Created by luben on 2016-03-09.
 */
interface Prototype {
    Object clone();

    String getName();
}

class Fill extends attributes implements Serializable {

    @Override
    public Fill execute(List<Canvas> c) {
        c.get(layer).getGraphicsContext2D().setFill(Color.valueOf(attribute));
        return this;
    }

    @Override
    public Object clone() {
        return Fill.attributeFactory(attribute);
    }


    public static attributes attributeFactory(String o) {
        Fill tmp = new Fill();
        tmp.setAttrbute(o);
        return tmp;

    }

    @Override
    public String getName() {
        return "fill";
    }
}


class Stroke extends attributes implements Serializable {

    @Override
    public Stroke execute(List<Canvas> c) {
        c.get(layer).getGraphicsContext2D().setStroke(Color.valueOf(attribute));
//        System.out.println(this+" "+con);
        return this;
    }

    @Override
    public Object clone() {
        return Stroke.attributeFactory(attribute);
    }



    public static attributes attributeFactory(String o) {
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

    public Square execute(List<Canvas> c) {
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
        c.get(layer).getGraphicsContext2D().fillRect(xStart, yStart, xStop, yStop);
        return this;
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

    public Line execute(List<Canvas> c) {
        c.get(layer).getGraphicsContext2D().strokeLine(start.getX(), start.getY(), stop.getX(), stop.getY());
//        System.out.println(this+" "+con);
//        System.out.println("lien: execute");
        return this;
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