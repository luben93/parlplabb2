package labb2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luben on 2016-03-09.
 */
public abstract class Shape implements Prototype, Command {
    Point start;
    Point stop;
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

    public void setStop(Point stop) {
        this.stop = stop;
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
        return "Shape "+getName()+" {" +
                "start=" + start +
                ", stop=" + stop +
                ", hash=" + hashCode() +
                '}';
    }
}
