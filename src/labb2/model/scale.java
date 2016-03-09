package labb2.model;

/**
 * Created by luben on 2016-03-09.
 */
public class scale extends point {

    private scale(int x, int y) {
        super(x, y);
    }

    public static scale scaleFactroy(int x,int y){
        return new scale(x,y);
    }
}
