package lesson7;

public class ClassTest {

    @BeforeSuite
    public static void beforeSuite(){
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public static void afterSuite(){
        System.out.println("AfterSuite");
    }

    @Test(priority = 5)
    public static void testPriority5(){
        System.out.println("testPriority5");
    }

    @Test(priority = 5)
    public static void testPriority5second(){
        System.out.println("testPriority5second");
    }

    @Test(priority = 10)
    public static void testPriority10(){
        System.out.println("testPriority10");
    }
    @Test
    public static void testNonPriority(){
        System.out.println("testNonPriority");
    }
    @Test(priority = 3)
    public static void testPriority3(){
        System.out.println("testPriority3");
    }

    @Test
    public static void testNonPriority2(){
        System.out.println("testNonPriority2");
    }


}
