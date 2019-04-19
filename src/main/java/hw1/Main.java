package hw1;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Light light = new Light();

        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[0-9]+$");

        System.out.println("Enter amount of minutes ('exit' for stop the program):");

        while (scanner.hasNext()) {
            String scanString = scanner.next();
            Matcher matcher = pattern.matcher(scanString);
            if (scanString.equalsIgnoreCase("exit") || (!matcher.find())) {
                break;
            }
            light.showState(Integer.parseInt(scanString));
        }
    }
}
