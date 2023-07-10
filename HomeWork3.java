import java.util.ArrayList;
import java.util.Random;

public class HomeWork3 {
    public static void main(String[] args) {
        // Task1(15);
        Task2(15);
    }

    // Задание 1
    // Пусть дан произвольный список целых чисел.
    // 1) Нужно удалить из него чётные числа
    // 2) Найти минимальное значение
    // 3) Найти максимальное значение
    // 4) Найти среднее значение

    // Не понял, какой тип данных нужно указывать при объявлении метода, чтобы он мог возвращать списки, поэтому - всё в одном методе
    static void Task1(int length) {
        ArrayList<Integer> list = new ArrayList<>(length);
        Random rnd = new Random();
        for (int i = 0; i < length; i++)
            list.add(rnd.nextInt(10));
        System.out.println("Изначальный список");
        int min = 0;
        int max = -1;
        float sum = 0;
        for (Integer iter : list)
            System.out.print(iter+" ");
        for (int i = 0; i < list.size(); i++){
            if ((list.get(i) % 2) == 0)
                {
                    list.remove(i);
                    i--;
                    continue;
                }
            else if ((max == -1) || (list.get(i) > max))
                max = list.get(i);
            else if (list.get(i) < min)
                min = list.get(i);
            sum += list.get(i);
        }
        System.out.println("\nБез чётных чисел");
        for (Integer iter : list)
            System.out.print(iter+" ");
        System.out.printf("\nМинимальное: %d\nМаксимальное: %d\nСреднее: %f",min,max,sum/list.size());
    }

    // Задание 2
    // Для списка из задачи про Солнечную систему удалить все повторяющиеся элементы.

    //За основу взят мой вариант, а не тот, который был продемонстрирован на семинаре
    static void Task2(int listLength){
        String[] planets = new String[]{"Меркурий","Венера","Земля","Марс","Юпитер","Сатурн","Уран","Нептун"}; //но это неточно :-)
        Integer[] counters = new Integer[planets.length];
        ArrayList<String> arrayList = new ArrayList<String>();
        Random rnd = new Random();
        System.out.println("Изначальный список:");
        for (int i = 0; i < listLength; i++) {
            int temp = rnd.nextInt(planets.length);
            arrayList.add(planets[temp]);
            if (counters[temp] == null)
                counters[temp] = 1;
            else
                counters[temp]++;
            System.out.println((i+1)+". "+planets[temp]);
        }
        System.out.println("\nСписок с подсчётом повторов:");
        for (int i = 0; i < counters.length; i++)
            if (counters[i] != null)
                System.out.printf("%s - %d\n",planets[i],counters[i]);
        for (int i = 0; i < counters.length; i++)
            if ((counters[i] != null) && (counters[i] > 1)){
                int count2del = counters[i];
                for (int j = 0; j < arrayList.size(); j++) {
                    if ((arrayList.get(j) == planets[i]) && (count2del > 1)){
                        arrayList.remove(j);
                        j--;
                        count2del--;
                    }
                }
            }
        System.out.println("\nФинальный список:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println((i+1)+". "+arrayList.get(i));
        }
    }
}
