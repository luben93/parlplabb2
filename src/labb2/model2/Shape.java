package labb2.model2;

import labb2.model.point;

/**
 * Created by luben on 2016-03-09.
 */
public abstract class Shape implements Prototype, Command {
    point start;
    point stop;

    public Object clone() {
        return null;
    }

    public point getStart() {
        return start;
    }

    public void setStart(point start) {
        this.start = start;
    }

    public point getStop() {
        return stop;
    }

    public void setStop(point stop) {
        this.stop = stop;
    }

    Shape(point start, point stop){

        this.start = start;
        this.stop = stop;
    }

}
