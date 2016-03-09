package labb2.model;

/**
 * Created by luben on 2016-03-09.
 */
public abstract class shape implements drawable, Prototype{
   public static shape shapeFactory(Object p, int next){
       return null;
   }
    @Override
    public shape clone(){
        return null;
    }
}
