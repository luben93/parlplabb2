package labb2.model;

/**
 * Created by luben on 2016-03-11.
 */
public abstract class attributes implements Command, Prototype {

    //    public static Attributes attributeFactory(Object o){
//        return null;
//    };
    @Override
    public abstract Object clone();

    public abstract void setAttrbute(Object o);

//    public abstract String getName();
}
