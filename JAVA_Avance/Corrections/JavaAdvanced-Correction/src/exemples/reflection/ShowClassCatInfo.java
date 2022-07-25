package exemples.reflection;

import exemples.reflection.beans.Cat;

public class ShowClassCatInfo {
	public static void main(String[] args) {

        // The Class object represent Cat class
        Class<Cat> aClass = Cat.class;

        // Class name
        System.out.println("Simple Class Name = " + aClass.getSimpleName());

        // Get the Class object represent parent of Cat class
        Class<?> aSuperClass = aClass.getSuperclass();

        System.out.println("Simple Class Name of Super class = "
                + aSuperClass.getSimpleName());

        // Determines the interfaces implemented by the class
        // or interface represented by this object.
        Class<?>[] itfClasses = aClass.getInterfaces();

        for (Class<?> itfClass : itfClasses) {
            System.out.println("Interface: " + itfClass.getSimpleName());
        }

    }
}
