package lesson2.cats;

public class Main {

    public static void main(String[] args) {
        Cat barsik = new Cat("Barsik", true, true);
        Cat murzik = new Cat("Murzik", true, false);
        checkCat(barsik, a -> a.isHungry());
        checkCat(barsik, a -> a.isHerbivore());
        checkCat(murzik, a -> a.isHungry());
        checkCat(murzik, a -> a.isHerbivore());



    }

    private static void checkCat(Cat cat, CheckCat checkCat) {
        if (checkCat.check(cat)) {
            System.out.println(cat);
        }
    }
}
