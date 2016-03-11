package labb2.model;

/**
 * Created by luben on 2016-03-10.
 */
public class Point {
    private int x,y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static Point pointFactory(int x, int y){
        return new Point(x,y);
    }

    private Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public Object clone(){
        return new Point(x,y);
    }
}
