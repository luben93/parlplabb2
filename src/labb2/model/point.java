package labb2.model;

/**
 * Created by luben on 2016-03-09.
 */
public class point {
    private int x;
    private int y;

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    protected point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public static point pointFactory(int x,int y){
         return new point(x,y);
    }
}
