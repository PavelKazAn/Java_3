package lesson3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClassForHomework3 {

    private static final ExecutorService service = Executors.newFixedThreadPool(3);
    private static final Object mon = new Object();
    private static final int NUMBER = 9;
    private volatile static String letter = "A";

    public static void main(String[] args) {
        printA();
        printB();
        printC();
        service.shutdown();
    }

    public static void printA(){
        service.execute(()->{
            synchronized (mon){
                for (int i = 0; i < NUMBER; i++) {
                    while (!letter.equals("A")){
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    letter = "B";
                    mon.notifyAll();
                }
            }
        });
    }

    public static void printB(){
        service.execute(()->{
            synchronized (mon){
                for (int i = 0; i < NUMBER; i++) {
                    while (!letter.equals("B")){
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    letter = "C";
                    mon.notifyAll();
                }
            }
        });
    }
    public static void printC(){
        service.execute(()->{
            synchronized (mon){
                for (int i = 0; i < NUMBER; i++) {
                    while (!letter.equals("C")){
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C ");
                    letter = "A";
                    mon.notifyAll();
                }
            }
        });
    }

}
