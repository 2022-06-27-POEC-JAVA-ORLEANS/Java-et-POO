package exemples.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import exemples.reflection.beans.Cat;

public class MethodExample {

    public static void main(String[] args) throws NoSuchMethodException,
            SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {

        // Class object represent Cat class
        Class<Cat> aClass = Cat.class;

        // Method object represent getAge() method.
        Method getAgeMethod = aClass.getMethod("getAge");
        
        // return type of method.
        Class<?> returnType= getAgeMethod.getReturnType();
        System.out.println("Return type of getAge: "+ returnType.getSimpleName());
        

        Cat tom = new Cat("Tom", 7);

       
        // Call method 'getAge' way Reflect
        // This is equivalent to calling: tom.getAge()
        int age = (int) getAgeMethod.invoke(tom);

        System.out.println("Age = " + age);

 
        // Method object represent setAge(int) method of Cat class.
        Method setAgeMethod = aClass.getMethod("setAge", int.class);


        // Call method setAge(int) way Reflect
        // This is equivalent to calling: tom.setAge(5)
        setAgeMethod.invoke(tom, 5);
        
        System.out.println("New Age = " + tom.getAge());
    }
    
}
