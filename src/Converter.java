public class Converter {
    double distance;
    double kcal;
    public Converter(int steps){
        distance = steps * 0.75 / 1000; // в километры
        kcal = steps * 50 / 1000; // в килокалории
    }
    void showResult(){                                                              // Метод расчета ккалорий и км
        System.out.println("Пройденое растояние: " + distance);
        System.out.println("Количество сожженых килокалорий: " + kcal);
    }
}
