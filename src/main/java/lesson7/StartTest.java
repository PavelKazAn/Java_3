package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StartTest {
    public static void start(Class mainClass) {
        List<Method> orderOfMethods = new ArrayList<>();
        Method[] methods = mainClass.getDeclaredMethods();
        int beforeSuitCounter = 0;
        int afterSuitCounter = 0;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                orderOfMethods.add(method);
            }
        }

        orderOfMethods.sort(Comparator.comparingInt((Method method) -> method.getAnnotation(Test.class).priority()));


        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuitCounter++;
                if (beforeSuitCounter > 1) {
                    throw new RuntimeException("@BeforeSuite должен быть только один");
                }
                orderOfMethods.add(method);
            }
        }

        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuitCounter++;
                if (afterSuitCounter > 1) {
                    throw new RuntimeException("@AfterSuite должен быть только один");
                }
                orderOfMethods.add(0, method);
            }
        }

        for (int i = orderOfMethods.size() - 1; i >= 0; i--) {
            try {
                orderOfMethods.get(i).invoke(null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
