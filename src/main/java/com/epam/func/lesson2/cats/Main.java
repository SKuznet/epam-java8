package com.epam.func.lesson2.cats;

public class Main {
    public static void main(String[] args) {
        Cat barsik = new Cat("Barsik", true, true);
        Cat murzik = new Cat("Murzik", true, false);

        checkCat(barsik, O -> O.isHungry());
        checkCat(barsik, O -> O.isHerbivore());
        checkCat(murzik, O -> O.isHungry());
        checkCat(murzik, O -> O.isHerbivore());

        checkCat(murzik, new CheckCat() {
            @Override
            public boolean check(Cat cat) {
                return cat.isHerbivore();
            }
        });
    }

    private static void checkCat(Cat cat, CheckCat checkCat) {
        if (checkCat.check(cat)) {
            System.out.println(cat);
        }
    }
}
