package labb2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luben on 2016-03-09.
 */
public abstract class Shape implements Prototype, Command,Serializable {
    Point start;
    Point stop;
    int layer;

    public Shape setLayer(int layer) {
        this.layer = layer;
        return this;
    }

    @Override
    public int getLayer() {
        return layer;
    }

    private List<String> attributes=new ArrayList<>();

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

    public Shape setStop(Point stop) {
        this.stop = stop;
        return this;
    }

    Shape(Point start, Point stop){

        this.start = start;
        this.stop = stop;
    }

    Shape () {  //An empty contructor is needed for the subclasses being able to be serialized

    }

//    public String toString(){
//        return getName();
//    }


    public List<String> getAttributes(){
//        List out =new ArrayList<String>();
        return attributes;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "start=" + start +
                ", stop=" + stop +
                ", layer=" + layer +
                ", attributes=" + attributes +
                '}';
    }
}
