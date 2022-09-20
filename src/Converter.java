public class Converter {

    double getKcal(int steps) {
        return  steps * 50.0 / 1000;
    }

    double getKilometres(int steps) {
        return  steps * 0.75 / 1000.0;
    }
}
