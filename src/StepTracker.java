import java.util.Scanner;

public class StepTracker{

    MonthData[] monthToData;
    int stepGoal;

    public StepTracker(){
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++){
            monthToData[i] = new MonthData();
        }
        stepGoal = 10000;


    }
    class MonthData{
        int[] dayValue = new int[30];
        MonthData(){
            for(int i = 0; i < dayValue.length; i++){
                dayValue[i] = 0;
            }
        }
    }


    public void showMonthData(int month){                                                   // Метод вывода статистики за месяц
        for (int j = 0; j < monthToData[month].dayValue.length; j++){                       // Вывод формата День : шаги
            System.out.println((j + 1) + " день: " + monthToData[month].dayValue[j]);
        }
        int stepPerMonth = 0;
        for (int x = 0; x < monthToData[month].dayValue.length; x++){                       // Вывод общее количество шагов за месяц
            stepPerMonth = stepPerMonth + monthToData[month].dayValue[x];
        }
            System.out.println("Общее количество шагов за месяц " + stepPerMonth);

        int maxStepPerMonth = 0;
        for(int m = 0; m < monthToData[month].dayValue.length; m++){                        // Вывод максимального количества шагов за месяц
            if(maxStepPerMonth < monthToData[month].dayValue[m]){
                maxStepPerMonth = monthToData[month].dayValue[m];
            }
        }
        System.out.println("Максимальное количество шагов за месяц " + maxStepPerMonth);

        double medianValueSteps = stepPerMonth / 30;                                        // Вывод среднего количества шагов за месяц
        System.out.println("Среднее количество шагов за месяц " + medianValueSteps);

        Converter converter = new Converter(stepPerMonth);                                  // Класс конвертер с расчетом ккалорий и км
        converter.showResult();                                                             // Вызываем метод с выводом в консоль
        int streakCount = 0;                                                                // Расчет максимального стрика
        int maxStreakCount = 0;
        for (int s = 0; s < monthToData[month].dayValue.length; s++){
            if(monthToData[month].dayValue[s] >= stepGoal){
                streakCount +=1;

            }
            else {
                if(maxStreakCount < streakCount){
                    maxStreakCount = streakCount;
                }
                 streakCount = 0;
            }
        }
        if(maxStreakCount < streakCount){
            maxStreakCount = streakCount;
        }


        System.out.println("Лучший стрик за месяц " + maxStreakCount);



    }


    void setStepGoal() {                                                                // Метод изменения цели количества шагов
        System.out.println("Введите цель шагов за день");
        Scanner scanner = new Scanner(System.in);
        int stepGoal1 = scanner.nextInt();
        if (stepGoal1 >= 0) {
            stepGoal = stepGoal1;
            System.out.println("Ваша цель - " + stepGoal + " шагов");
        } else {
            System.out.println("Введено недопустимое значение");
        }

    }

    void addStepPerDay(){                                                               // Метод добавляющий пройденные шаги за день
        System.out.println("Выберите месяц");
        System.out.println("0 - Январь, 1 - Февраль, 2 - Март, 3 - Апрель, 4 - Май, 5 - Июнь, 6 - Июль, 7 - Август, 8 - Сентябрь, 9 - Октябрь, 10 - Ноябрь, 11 - Декабрь");
        Scanner scanner = new Scanner(System.in);
        if(true){
            int month = scanner.nextInt();
            System.out.println("Выберите день в который хотите добавить количество шагов");
            int sDay = scanner.nextInt();
            System.out.println("Введите количество шагов");
            int stepPerDay = scanner.nextInt();
            if(sDay >= 0 && month >= 0 && stepPerDay >= 0){
                monthToData[month].dayValue[sDay - 1] = stepPerDay;
            }
            else {
                System.out.println("Неизвестное значение");
            }
        }
    }







}


