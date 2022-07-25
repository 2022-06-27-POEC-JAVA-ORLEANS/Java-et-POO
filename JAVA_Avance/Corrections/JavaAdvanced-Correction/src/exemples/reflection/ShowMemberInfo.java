package exemples.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import exemples.reflection.beans.Cat;

public class ShowMemberInfo {
	public static void main(String[] args) {


        // Get object represent Cat class.
        Class<Cat> aClass = Cat.class;

        // Get Constructor array of Cat.
        Constructor<?>[] constructors = aClass.getConstructors();

        System.out.println(" ==== CONSTRUCTORs:  ===== ");

        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor.getName());
        }

       
        // Get a list of public method of Cat
        // Include the methods inherited from the parent class and the interfaces
        Method[] methods = aClass.getMethods();

        System.out.println(" ==== METHODs:   ====== ");
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
        }

     
        // Get the list of the public fields
        // Include the fields inherited from the parent class, and the interfaces
        Field[] fields = aClass.getFields();

        System.out.println(" ==== FIELDs:    ====== ");
        for (Field field : fields) {
            System.out.println("Field: " + field.getName());
        }

    }
}
