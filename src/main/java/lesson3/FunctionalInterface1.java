package lesson3;

public interface FunctionalInterface1 {
    default void sayHello() {
        System.out.println("Hello!");
    }

    static void getInfo() {
        System.out.println("Hello from static method from interface");
    }
}
