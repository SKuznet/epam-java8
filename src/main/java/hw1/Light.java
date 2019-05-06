package hw1;

public enum Light {
    RED(2), YELLOW(3), GREEN(6);

    private int time;

    Light(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
