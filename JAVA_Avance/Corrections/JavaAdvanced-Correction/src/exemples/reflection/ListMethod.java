package exemples.reflection;

import java.lang.reflect.Method;

public class ListMethod {

    // Protected method
    protected void info() {

    }

    public static void testMethod1() {

    }

    public void testMethod2() {

    }

    public static void main(String[] args) {
        
        // Get a list of public methods of this class
        // Include methods inherited from the parent class, or interface.
        Method[] methods = ListMethod.class.getMethods();

        for (Method method : methods) {
            System.out.println("Method " + method.getName());
        }

    }
}
