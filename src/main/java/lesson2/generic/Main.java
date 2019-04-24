package lesson2.generic;

public class Main {

    public static void main(String[] args) {
        Cat barsik = new Cat(20, "Barsik", true, true);
        Cat murzik = new Cat(30, "Murzik", true, false);

        printSpeed(barsik, O -> O.getSpeed());
        printSpeed(murzik, O -> O.getSpeed());

        printHungryStatus(barsik, O -> O.isHungry());
        printHungryStatus(murzik, O -> O.isHungry());

        print(murzik, O -> O.isHerbivore());


    }
    private static void printSpeed(Cat cat, CheckSpeed checkSpeed){
        System.out.println(checkSpeed.get(cat));
    }

    private static void printHungryStatus(Cat cat, CheckHungry checkHungry) {
        System.out.println(checkHungry.get(cat));
    }

    private static void print(Cat cat, Check check ) {
        System.out.println(check.get(cat));
    }
}
