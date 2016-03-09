package labb2.model2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static labb2.model2.PrototypeDemo.initializePrototypes;

/**
 * Created by luben on 2016-03-09.
 */
public class PrototypesModule {
    // 2. "registry" of prototypical objs
    private static ArrayList<Prototype> prototypes = new ArrayList<Prototype>();
//    private static int total = 0;

    // Adds a feature to the Prototype attribute of the PrototypesModule class
    // obj  The feature to be added to the Prototype attribute
    public static void addPrototype(Prototype obj) {
        prototypes.add(obj);
    }

    public static Shape findAndClone(String name) {
        // 4. The "virtual ctor"
        return (Shape) prototypes.stream().filter(prototype -> prototype.getName().equals(name)).findFirst().orElse(null);
    }

    public static List<String> listNames(){
        return prototypes.stream().map(Prototype::getName).collect(Collectors.toList());
    }

    public static void init(){
        initializePrototypes();
    }
}
