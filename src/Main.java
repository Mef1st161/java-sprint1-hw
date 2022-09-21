import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         final int COMMAND_FOUR = 4;
         final int COMMAND_THREE = 3;
         final int COMMAND_TWO = 2;
         final int COMMAND_ONE = 1;

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != COMMAND_FOUR) {

            if (userInput == COMMAND_ONE) {
                stepTracker.addStepPerDay();
            }
            else if (userInput == COMMAND_TWO) {
                System.out.println("Выберите месяц за который хотите получить статистику");
                System.out.println("0 - Январь, 1 - Февраль, 2 - Март, 3 - Апрель, 4 - Май, 5 - Июнь, 6 - Июль, 7 - Август, 8 - Сентябрь, 9 - Октябрь, 10 - Ноябрь, 11 - Декабрь");
                int month = scanner.nextInt();
                stepTracker.showMonthData(month);
            }
            else if (userInput == COMMAND_THREE) {
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

// Не смог разобраться в пакетах и default package (кстати пакет с именем default не создается),
// решил сдать без использования пакетов так как сегодня последний день когда я могу отправить исправления до окончания дедлайна
// Константы в методе main нельзя создавать с модификатором private, побоялся добавлять их в класс Main так как незнаю можно ли так делать.
