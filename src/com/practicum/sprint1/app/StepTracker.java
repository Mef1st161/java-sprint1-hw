package com.practicum.sprint1.app;

import java.util.Scanner;

public class StepTracker {
    private final Converter converter = new Converter();
    private final MonthData[] monthToData;
    private int stepGoal;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        stepGoal = 10000;
    }

    private static class MonthData {
        private final int[] dayValue = new int[30];
    }

    public void showMonthStatistics(int month) {
        for (int i = 0; i < monthToData[month].dayValue.length; i++) {
            System.out.println((i + 1) + " день: " + monthToData[month].dayValue[i]);
        }
        int stepsPerMonth = 0;
        for (int i = 0; i < monthToData[month].dayValue.length; i++) {
            stepsPerMonth = stepsPerMonth + monthToData[month].dayValue[i];
        }
        System.out.println("Общее количество шагов за месяц " + stepsPerMonth);

        int maxStepPerMonth = 0;
        for (int i = 0; i < monthToData[month].dayValue.length; i++) {
            if (maxStepPerMonth < monthToData[month].dayValue[i]) {
                maxStepPerMonth = monthToData[month].dayValue[i];
            }
        }
        System.out.println("Максимальное количество шагов за месяц " + maxStepPerMonth);

        double averageValueSteps = stepsPerMonth / 30d;
        System.out.println("Среднее количество шагов за месяц " + averageValueSteps);
        System.out.println("Пройденное расстояние: " + converter.getKilometres(stepsPerMonth));
        System.out.println("Количество сожжённых калорий: " + converter.getKcal(stepsPerMonth));
        int streakCount = 0;
        int maxStreakCount = 0;
        for (int i = 0; i < monthToData[month].dayValue.length; i++) {
            if (monthToData[month].dayValue[i] >= stepGoal) {
                streakCount +=1;
                if (maxStreakCount < streakCount) {
                    maxStreakCount = streakCount;
                }
            }
            else {
                streakCount = 0;
            }

        }

        System.out.println("Лучшая серия достигнутых целей за месяц " + maxStreakCount);
    }

    void setStepGoal() {
        System.out.println("Введите цель шагов за день");
        Scanner scanner = new Scanner(System.in);
        int stepGoal1 = scanner.nextInt();
        if (stepGoal1 >= 0) {
            stepGoal = stepGoal1;
            System.out.println("Ваша цель - " + stepGoal + " шагов");
        } else
            System.out.println("Введено недопустимое значение");
    }

    void addStepPerDay() {
        System.out.println("Выберите месяц");
        System.out.println("0 - Январь, 1 - Февраль, 2 - Март, 3 - Апрель, 4 - Май, 5 - Июнь, 6 - Июль, 7 - Август, 8 - Сентябрь, 9 - Октябрь, 10 - Ноябрь, 11 - Декабрь");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        if (month >= 0 && month <= 11) {
            System.out.println("Выберите день в который хотите добавить количество шагов");
            int selectDay = scanner.nextInt();
            if (selectDay > 0 && selectDay <= 30) {
                System.out.println("Сколько шагов вы хотите добавить?");
                int stepPerDay = scanner.nextInt();
                if (stepPerDay >= 0) {
                    monthToData[month].dayValue[selectDay-1] = stepPerDay;
                }
                else {
                    System.out.println("Выбрано неизвестное значение. Количество шагов не может быть отрицательным");
                }
            }
            else {
                System.out.println("Выбрано неизвестное значение. Количество дней должно быть в промежутке от 1 до 30");
            }
        }
        else {
            System.out.println("Выбрано неизвестное значение. Месяц должен быть выбран в промежутке от 0 до 11");
        }
    }
}


