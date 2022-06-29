package ModerneProgrammierkonzepte.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) {
        Person myPerson = new Person();
        System.out.println(myPerson);

        try {
            var c = Class.forName("ModerneProgrammierkonzepte.Reflection.Person").getDeclaredConstructor(new Class[0]).newInstance();
            System.out.println(c.getClass().getName());
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Method[] methods = myPerson.getClass().getMethods();

        for (Method method:
             methods) {
            System.out.println(method.getName());
        }
    }
}
