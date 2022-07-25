package exemples.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import exemples.reflection.beans.Cat;

public class ConstructorExample {

    public static void main(String[] args) throws NoSuchMethodException,
            SecurityException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {


        // Get Class object represent Cat class.
        Class<Cat> aClass = Cat.class;


        // Get the Constructor object of the public constructor
        // that matches the specified parameterTypes
        Constructor<?> constructor = aClass.getConstructor(String.class,
                int.class);


        // Get parameter array of this constructor.
        Class<?>[] paramClasses = constructor.getParameterTypes();

        for (Class<?> paramClass : paramClasses) {
            System.out.println("Param: " + paramClass.getSimpleName());
        }


        // Initialize the object in the usual way
        Cat tom = new Cat("Tom", 3);
        System.out
                .println("Cat 1: " + tom.getName() + ", age =" + tom.getAge());


        // Using Java reflection to create object
        Cat tom2 = (Cat) constructor.newInstance("Tom", 2);
        System.out.println("Cat 2: " + tom.getName() + ", age ="
                + tom2.getAge());
    }
}
