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

class LineWidth extends attributes implements Serializable {

    @Override
    public Object clone() {
        return LineWidth.attributeFactory(attribute);
    }

    @Override
    public String getName() {
        return "linewidth";
    }

    @Override
    public Command execute(List<Canvas> c) {
        c.get(layer).getGraphicsContext2D().setLineWidth(Double.valueOf(attribute));
        return this;
    }

    public static LineWidth attributeFactory(String o) {
        LineWidth tmp = new LineWidth();
        tmp.setAttrbute(o);
        return tmp;
    }
}

class setFilled extends attributes implements Serializable {


    @Override
    public String getName() {
        return "setfill";
    }

    @Override
    public Command execute(List<Canvas> c) {
        if (attribute.equals("stroke")) {
            c.get(layer).getGraphicsContext2D().stroke();
        }else {
            c.get(layer).getGraphicsContext2D().fill();
        }
        System.out.println("executing set fill" + layer);
        return this;
    }

    public static setFilled attributeFactory(String s) {
        setFilled tmp = new setFilled();
        tmp.setAttrbute(s);
        return tmp;
    }

    @Override
    public Object clone() {
        return attributeFactory(attribute);
    }
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


    public static Fill attributeFactory(String o) {
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


    public static Stroke attributeFactory(String o) {
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
        getAttributes().add("stroke");
        getAttributes().add("fill");
        getAttributes().add("linewidth");
        getAttributes().add("setfill");

    }


    public Object clone() {
        return new Square(start, stop);
    }

    public String getName() {
        return "square";
    }

    public Square execute(List<Canvas> c) {
//        int xStop = stop.getX();//Math.abs(stop.getX() - start.getX());
//        int yStop = stop.getY();//Math.abs(stop.getY() - start.getY());
//        int xStart = start.getX();
//        int yStart = start.getY();
//        if (xStop < xStart) {
//            int tmp = xStart;
//            xStart = xStop;
//            xStop = tmp;
//        }
//        if (yStop < yStart) {
//            int tmp = yStart;
//            yStart = yStop;
//            yStop = tmp;
//        }
//        xStop = Math.abs(xStop - xStart);
//        yStop = Math.abs(yStop - yStart);
//        c.get(layer).getGraphicsContext2D().strokeRect(xStart, yStart, xStop, yStop);
//        System.out.println(this);
        c.get(layer).getGraphicsContext2D().beginPath();
        c.get(layer).getGraphicsContext2D().moveTo(start.getX(), start.getY());
        c.get(layer).getGraphicsContext2D().lineTo(start.getX(), stop.getY());
        c.get(layer).getGraphicsContext2D().lineTo(stop.getX(), stop.getY());
        c.get(layer).getGraphicsContext2D().lineTo(stop.getX(), start.getY());
        c.get(layer).getGraphicsContext2D().closePath();
//        c.get(layer).getGraphicsContext2D().fill();
//        c.get(layer).getGraphicsContext2D().stroke();
        return this;
    }
}

class Oval extends Shape {
    Oval(Point start, Point stop) {
        super(start, stop);
        getAttributes().add("stroke");
        getAttributes().add("linewidth");
        getAttributes().add("fill");
//        getAttributes().add("setfill");

    }


    public Object clone() {
        return new Oval(start, stop);
    }

    public String getName() {
        return "oval";
    }

    public Oval execute(List<Canvas> c) {
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
        c.get(layer).getGraphicsContext2D().strokeOval(xStart, yStart, xStop, yStop);


        return this;
    }
}

class Triangle extends Shape {
    Triangle(Point start, Point stop) {
        super(start, stop);
        getAttributes().add("stroke");
        getAttributes().add("linewidth");
        getAttributes().add("fill");
        getAttributes().add("setfill");


    }


    public Object clone() {
        return new Triangle(start, stop);
    }

    public String getName() {
        return "triangle";
    }

    public Triangle execute(List<Canvas> c) {
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


//        c.get(layer).getGraphicsContext2D().strokePolygon(new double[]{(double) xStart, (double) (xStart + xStop) / 2, (double) xStop, (double) (xStart + xStop) / 2},
//                new double[]{(double) (yStart + yStop) / 2, (double) yStart, (double) (yStart + yStop) / 2, (double) yStop},
//                4);
        c.get(layer).getGraphicsContext2D().beginPath();
        c.get(layer).getGraphicsContext2D().moveTo((xStart + xStop) / 2, start.getY());
        c.get(layer).getGraphicsContext2D().lineTo(start.getX(), yStop);
        c.get(layer).getGraphicsContext2D().lineTo(stop.getX(), yStop);
        c.get(layer).getGraphicsContext2D().lineTo((xStart + xStop) / 2, start.getY());
        c.get(layer).getGraphicsContext2D().closePath();
        return this;
    }
}

class Line extends Shape {
    Line(Point start, Point stop) {
        super(start, stop);
        getAttributes().add("stroke");
        getAttributes().add("linewidth");
//        getAttributes().add("fill");
//        getAttributes().add("setfill");

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
        PrototypesModule.addPrototype(new Oval(zero, zero));
        PrototypesModule.addPrototype(new Triangle(zero, zero));
        PrototypesModule.addPrototype(new Fill());
        PrototypesModule.addPrototype(new Stroke());
        PrototypesModule.addPrototype(new LineWidth());
        PrototypesModule.addPrototype(new setFilled());
    }

}