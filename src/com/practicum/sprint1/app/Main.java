package com.practicum.sprint1.app;
import java.util.Scanner;

public class Main {
    private static final int EXIT_MENU = 4;
    private static final int STEP_GOAL_EDIT_MENU = 3;
    private static final int STATISTICS_PRINT_MENU = 2;
    private static final int STEP_PER_DAY_INSERT_MENU = 1;
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != EXIT_MENU) {

            if (userInput == STEP_PER_DAY_INSERT_MENU) {
                stepTracker.addStepPerDay();
            }
            else if (userInput == STATISTICS_PRINT_MENU) {
                System.out.println("Выберите месяц за который хотите получить статистику");
                System.out.println("0 - Январь, 1 - Февраль, 2 - Март, 3 - Апрель, 4 - Май, 5 - Июнь, 6 - Июль, 7 - Август, 8 - Сентябрь, 9 - Октябрь, 10 - Ноябрь, 11 - Декабрь");
                int month = scanner.nextInt();
                stepTracker.showMonthStatistics(month);
            }
            else if (userInput == STEP_GOAL_EDIT_MENU) {
                stepTracker.setStepGoal();
            }
            else {
                System.out.println("Неизвестная команда. Выберите команду из предложенных");
            }

            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");

    }

    private static void printMenu() {
        System.out.println(" 1 - Ввести количество шагов за определенный день");
        System.out.println(" 2 - Напечатать статистику за определенный месяц");
        System.out.println(" 3 - Изменить цель по количеству шагов в день");
        System.out.println(" 4 - Выйти из приложения");
    }

}

