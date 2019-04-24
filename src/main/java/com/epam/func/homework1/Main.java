package com.epam.func.homework1;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        UnaryOperator<Integer> check = o->o.compareTo(0);
        Predicate<Integer> isNormalInput = o->check.apply(o)>0;
        TrafficLight trafficLight =  new TrafficLight();
        Scanner scanner =  new Scanner(System.in);
        while(scanner.hasNextInt()){
            int next = scanner.nextInt();
            if(isNormalInput.test(next))
                System.out.println(trafficLight.getLight(next));
            else
                break;
        }
    }
}
