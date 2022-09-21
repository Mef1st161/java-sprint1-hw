public class Converter {

    private final double CALORIE_RATIO = 50.0;
    private final int TO_KILOMETRES = 1000;
    private final double STEP_LENGTH = 0.75;

    double getKcal(int steps) {
        return  steps * CALORIE_RATIO / TO_KILOMETRES;
    }

    double getKilometres(int steps) {
        return  steps * STEP_LENGTH / TO_KILOMETRES;
    }
}
