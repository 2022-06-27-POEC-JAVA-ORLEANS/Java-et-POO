package exemples.reflection;

import java.lang.reflect.Modifier;

public final class ShowClassInfo {
    public static void main(String[] args) {

    	  
        // Get Class object represent ShowClassInfo class.
        Class<ShowClassInfo> aClass = ShowClassInfo.class;


        // Print out class name, including the package name.
        System.out.println("Class Name= " + aClass.getName());


        // Print out simple class name (without package name).
        System.out.println("Simple Class Name= " + aClass.getSimpleName());

        // Package info
        Package pkg = aClass.getPackage();
        System.out.println("Package Name = " + pkg.getName());

        // Modifier
        int modifiers = aClass.getModifiers();

        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isInterface = Modifier.isInterface(modifiers);
        boolean isAbstract = Modifier.isAbstract(modifiers);
        boolean isFinal = Modifier.isFinal(modifiers);

        // true
        System.out.println("Is Public? " + isPublic);
        // true
        System.out.println("Is Final? " + isFinal);
        // false
        System.out.println("Is Interface? " + isInterface);
        // false
        System.out.println("Is Abstract? " + isAbstract);
    }
}
