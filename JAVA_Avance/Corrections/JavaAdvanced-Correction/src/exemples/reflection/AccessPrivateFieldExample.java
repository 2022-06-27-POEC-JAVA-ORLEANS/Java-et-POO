package exemples.reflection;

import java.lang.reflect.Field;

import exemples.reflection.beans.Cat;

public class AccessPrivateFieldExample {

	   public static void main(String[] args) throws IllegalArgumentException,
	           IllegalAccessException, NoSuchFieldException, SecurityException {


	       // Class object represent Cat class
	       Class<Cat> aClass = Cat.class;

	     
	       // Class.getField(String) get public field only.
	       // Use Class.getDeclaredField(String):
	       // Get the Field object of field declared in class.
	       Field private_nameField = aClass.getDeclaredField("name");

	   
	       // Allows for access to private field.
	       // Avoid IllegalAccessException
	       private_nameField.setAccessible(true);

	       Cat tom = new Cat("Tom");

	       String fieldValue = (String) private_nameField.get(tom);
	       System.out.println("Value field name = " + fieldValue);

	       // Set new value for 'name' field.
	       private_nameField.set(tom, "Tom Cat");

	       System.out.println("New name = " + tom.getName());
	   }

}
