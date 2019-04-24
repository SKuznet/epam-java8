package lesson2.generic;

public class Cat {
    private int speed;
    private  String name;
    private boolean isHungry;
    private boolean isHerbivore;

    public Cat(int speed, String name, boolean isHungry, boolean isHerbivore) {
        this.speed = speed;
        this.name = name;
        this.isHungry = isHungry;
        this.isHerbivore = isHerbivore;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public boolean isHerbivore() {
        return isHerbivore;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", isHungry=" + isHungry +
                ", isHerbivore=" + isHerbivore +
                '}';
    }
}
