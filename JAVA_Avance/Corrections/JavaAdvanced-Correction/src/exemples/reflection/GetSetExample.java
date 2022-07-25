package exemples.reflection;

import java.lang.reflect.Method;

import exemples.reflection.beans.Cat;

public class GetSetExample {

    // Method is getter if names start with get, and no parameters.
    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        if (void.class.equals(method.getReturnType())) {
            return false;
        }
        return true;
    }

    
 
    // Method is setter if names start with set, and only one parameter.
    public static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) {
            return false;
        }
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        // Class object represet Cat class
        Class<Cat> aClass = Cat.class;

        // public methods
        Method[] methods = aClass.getMethods();

        for (Method method : methods) {
            boolean isSetter = isSetter(method);
            boolean isGetter = isGetter(method);
            System.out.println("Method: " + method.getName());
            System.out.println(" - Is Setter? " + isSetter);
            System.out.println(" - Is Getter? " + isGetter);
        }

    }
    
}
