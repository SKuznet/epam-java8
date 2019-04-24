package hw1;

import java.util.Optional;

class LightController {
    private LightColor lightColor = new LightColor();

    String getLightByMinute(double minute) {
        double workTime = minute % 6;

        return Optional.of(
        workTime > 0 && workTime <= 2 ? lightColor.makeRedLight().getColor() :
        workTime > 2 && workTime <= 3 ? lightColor.makeYellowColor().getColor() :
                lightColor.makeGreenColor().getColor()
        ).get();
    }
}
