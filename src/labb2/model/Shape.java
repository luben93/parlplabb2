package labb2.model;

/**
 * Created by luben on 2016-03-09.
 */
public abstract class Shape implements Prototype, Command {
    Point start;
    Point stop;

    public Object clone() {
        return null;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getStop() {
        return stop;
    }

    public void setStop(Point stop) {
        this.stop = stop;
    }

    Shape(Point start, Point stop){

        this.start = start;
        this.stop = stop;
    }

    public String toString(){
        return getName();
    }

}
