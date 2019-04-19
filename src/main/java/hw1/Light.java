package hw1;

import hw1.enums.State;

import java.util.HashMap;
import java.util.Map;

class Light {
    private State state;
    private static Map<Integer, State> map;

static {
    map = new HashMap<>();
    map.put(0, State.RED);
    map.put(1, State.RED);
    map.put(2, State.YELLOW);
    map.put(3, State.GREEN);
    map.put(4, State.GREEN);
    map.put(5, State.GREEN);
}

    void showState(int minute) {
        state = (map.get(minute % 6));
        System.out.println(state);
    }
}
