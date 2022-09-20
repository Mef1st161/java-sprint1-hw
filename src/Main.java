import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 4) {

            if (userInput == 1) {
                stepTracker.addStepPerDay();
            }
            else if (userInput == 2) {
                System.out.println("Выберите месяц за который хотите получить статистику");
                System.out.println("0 - Январь, 1 - Февраль, 2 - Март, 3 - Апрель, 4 - Май, 5 - Июнь, 6 - Июль, 7 - Август, 8 - Сентябрь, 9 - Октябрь, 10 - Ноябрь, 11 - Декабрь");
                int month = scanner.nextInt();
                stepTracker.showMonthData(month);
            }
            else if (userInput == 3) {
                stepTracker.setStepGoal();
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
