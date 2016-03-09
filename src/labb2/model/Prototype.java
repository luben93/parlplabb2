package labb2.model;


/**
 * Created by luben on 2016-03-09.
 */
public interface Prototype {

    Object clone();

    String getName();

}

class PrototypesModule {
    // 2. "registry" of prototypical objs
    private static Prototype[] prototypes = new Prototype[9];//TODO increase when adding more leaf drawables
    private static int total = 0;

    // Adds a feature to the Prototype attribute of the PrototypesModule class
    // obj  The feature to be added to the Prototype attribute
    public static void addPrototype(Prototype obj) {
        prototypes[total++] = obj;
    }

    public static Object findAndClone(String name) {
        // 4. The "virtual ctor"
        for (int i = 0; i < total; i++) {
            if (prototypes[i].getName().equals(name)) {
                return prototypes[i].clone();
            }
        }
        System.out.println(name + " not found");
        return null;
    }

    public static void initializePrototypes() {
        point zero = point.pointFactory(0, 0);
        PrototypesModule.addPrototype(line.shapeFactory(zero, zero));
        PrototypesModule.addPrototype(square.shapeFactory(zero, zero));//TODO add all leaf drawables here
//        PrototypesModule.addPrototype( new TheOther() );
    }
}