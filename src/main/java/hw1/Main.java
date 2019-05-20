package hw1;


public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Process());
        thread.start();
    }
}
