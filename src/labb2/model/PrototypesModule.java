package labb2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static labb2.model.PrototypeDemo.initializePrototypes;

/**
 * Created by luben on 2016-03-09.
 */
public class PrototypesModule {
    private static ArrayList<Prototype> prototypes = new ArrayList<Prototype>();

    public static void addPrototype(Prototype obj) {
        prototypes.add(obj);
    }

    public static Prototype findAndClone(String name) {
        Prototype p= (Prototype) prototypes.stream().filter(prototype -> prototype.getName().equals(name)).findFirst().orElse(null);
        return (Prototype) p.clone();
    }

    public static Prototype findAndCloneAttributes(String name, Object o){
        Attributes a = (Attributes) findAndClone(name);
        a.setAttrbute(o);
        return a;
    }

    public static List<String> listShapeNames(){
        return prototypes.stream().filter(prototype -> prototype instanceof Shape ).map(Prototype::getName).collect(Collectors.toList());

    }

    public static void init(){
        initializePrototypes();
    }
}
