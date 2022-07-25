package exemples.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import exemples.reflection.beans.Cat;

public class AccessPrivateMethodExample {

	   public static void main(String[] args) throws NoSuchMethodException,
	           SecurityException, IllegalAccessException,
	           IllegalArgumentException, InvocationTargetException {

	       // Class object represent Cat class.
	       Class<Cat> aClass = Cat.class;

	     
	       // Class.getMethod(String) get public method only.
	       // Use Class.getDeclaredMethod(String):
	       // Get the Method object of method declared in class.        
	       Method private_setNameMethod = aClass.getDeclaredMethod("setName",
	               String.class);

	       // Allows for access to private method.
	       // Avoid IllegalAccessException        
	       private_setNameMethod.setAccessible(true);

	       Cat tom = new Cat("Tom");

	       // Call private method
	       private_setNameMethod.invoke(tom, "Tom Cat");

	       System.out.println("New name = " + tom.getName());
	   }
	   
}
