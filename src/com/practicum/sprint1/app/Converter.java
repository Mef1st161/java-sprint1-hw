package com.practicum.sprint1.app;

public class Converter {

    private static final double CALORIE_RATIO = 50.0;
    private static final int TO_KILOMETRES = 1000;
    private static final double STEP_LENGTH = 0.75;

    public double getKcal(int steps) {
        return  steps * CALORIE_RATIO / TO_KILOMETRES;
    }

    public double getKilometres(int steps) {
        return  steps * STEP_LENGTH / TO_KILOMETRES;
    }
}
