import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class HomeWork3 {
    public static void main(String[] args) {
        Task1(15);
    }

    // Задание 1
    // Пусть дан произвольный список целых чисел.
    // 1) Нужно удалить из него чётные числа
    // 2) Найти минимальное значение
    // 3) Найти максимальное значение
    // 4) Найти среднее значение
    static void Task1(int length) {
        //ArrayList<Integer> arrayList = randomList(listLength);
        printList(randomList(length));
    }

    static Object randomList(int length){
        List<Integer> list = new List<Integer>();
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            list.add(rnd.nextInt(10));
        }
        return(arrayList);
    }

    static void printList( list){
        for (Integer iter : list) {
            System.out.print(iter+" ");
        }
    }

}
