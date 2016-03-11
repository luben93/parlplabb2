package labb2.model;

import javafx.scene.canvas.Canvas;
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
        if (o.getClass().equals(Color.class)) {
//            Fill tmp = new Fill();
            color = (Color) o;
//            return this;
        }
//        return null;

    }


    public static Attributes attributeFactory(Object o) {
//        if (o.getClass().equals(Color.class)) {
        Fill tmp = new Fill();
        tmp.setAttrbute(o);
        return tmp;
//        }
//        return null;
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
        System.out.printf("execute stroke");
    }

    @Override
    public Object clone() {
        return Stroke.attributeFactory(color);
    }

    @Override
    public void setAttrbute(Object o) {
        if (o.getClass().equals(Color.class)) {
            color = (Color) o;
//            return this;
        }
//        return null;
    }


    public static Attributes attributeFactory(Object o) {
//        if (o.getClass().equals(Color.class)) {
        Stroke tmp = new Stroke();
        tmp.setAttrbute(o);
        return tmp;
//        }
//        return null;
    }

    @Override
    public String getName() {
        return "stroke";
    }
}


//class PrototypesModule {
//    // 2. "registry" of prototypical objs
//    private static Prototype[] prototypes = new Prototype[9];
//    private static int total = 0;
//
//    // Adds a feature to the Prototype attribute of the PrototypesModule class
//    // obj  The feature to be added to the Prototype attribute
//    public static void addPrototype(Prototype obj) {
//        prototypes[total++] = obj;
//    }
//
//    public static Object findAndClone(String name) {
//        // 4. The "virtual ctor"
//        for (int i = 0; i < total; i++) {
//            if (prototypes[i].getName().equals(name)) {
//                return prototypes[i].clone();
//            }
//        }
//        System.out.println(name + " not found");
//        return null;
//    }
//}

// 5. Sign-up for the clone() contract.
// Each class calls "new" on itself FOR the client.
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
//        System.out.println("suqare: execute");
    }
}

class Line extends Shape {
    Line(Point start, Point stop) {
        super(start, stop);
        getAttributes().add("stroke");
    }

    public Object clone() {
        return new Line(start, stop);
    }

    public String getName() {
        return "line";
    }

    public void execute(GraphicsContext con) {
        con.strokeLine(start.getX(), start.getY(), stop.getX(), stop.getY());
        System.out.println(this);
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
//        PrototypesModule.addPrototype(new Shape());
    }

    public static void main(String[] args) {
        args = new String[4];
        args[1] = "line";
        args[2] = "square";
        args[3] = "shape";
        initializePrototypes();
        Object[] objects = new Object[9];
        int total = 0;

        // 6. Client does not use "new"
        for (int i = 0; i < args.length; i++) {
            objects[total] = PrototypesModule.findAndClone(args[i]);
            if (objects[total] != null) total++;
        }
        GraphicsContext con = new Canvas().getGraphicsContext2D();
        for (int i = 0; i < total; i++) {
            ((Command) objects[i]).execute(con);
        }
    }
}