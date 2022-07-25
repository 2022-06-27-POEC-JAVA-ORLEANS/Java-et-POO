package exemples.reflection;

import java.lang.reflect.Field;

import exemples.reflection.beans.Cat;

public class FieldExample {

    public static void main(String[] args) throws NoSuchFieldException,
            SecurityException, IllegalArgumentException, IllegalAccessException {
        

        // Get Class object represent Cat class
        Class<Cat> aClass = Cat.class;


        // Get Field object represent field 'NUMBER_OF_LEGS'.
        Field field = aClass.getField("NUMBER_OF_LEGS");

        
        Class<?> fieldType = field.getType();

        System.out.println("Field type: " + fieldType.getSimpleName());

        Field ageField = aClass.getField("age");

        Cat tom = new Cat("Tom", 5);

        // Returns the value of the field represented by this Field,
        // on the specified object.
        Integer age = (Integer) ageField.get(tom);
        System.out.println("Age = " + age);
        

        // Sets the field represented by this Field object on
        // the specified object argument to the specified new value.
        ageField.set(tom, 7);
        
        System.out.println("New Age = "+ tom.getAge());
        

    }
}
