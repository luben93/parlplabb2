package labb2.model;

import java.io.Serializable;

/**
 * Created by luben on 2016-03-11.
 */
public abstract class attributes implements Command, Prototype,Serializable {
    String attribute;
    //    public static Attributes attributeFactory(Object o){
//        return null;
//    };
    @Override
    public abstract Object clone();

    public void setAttrbute(String o) {
        attribute=o;
    }

//    public abstract String getName();
}
