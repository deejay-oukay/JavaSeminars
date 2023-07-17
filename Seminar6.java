import java.util.ArrayList;
import java.util.Random;

public class Seminar6 {
    public static void main(String[] args) {
        uniqElems(randomArray(100));
    }

    // Создать метод, формирующий массив из N случайных чисел
    static int[] randomArray(int N) {
        int[] array = new int[N];
        Random rnd = new Random();
        for (int i = 0; i < N; i++) {
            array[i] = rnd.nextInt(100);
        }
        System.out.print("Оригинальный массив: ");
        for (int i = 0; i < N; i++)
            System.out.print(array[i] + " ");
        return (array);
    }

    // Создать метод, в который передаётся заполненный методом выше массив, и с
    // помощью Set вычислить процент уникальных значений в данном массиве
    // (кол-во уникальных / общее кол-во * 100)
    static void uniqElems(int[] array) {
        ArrayList<Integer> uniq = new ArrayList<>();
        System.out.print("\nМассив с уникальными значениями: ");
        for (int i = 0; i < array.length; i++) {
            if (!uniq.contains(array[i])) {
                uniq.add(array[i]);
                System.out.print(array[i] + " ");
            }
        }
        System.err.print("\nПроцент уникальности: " + (uniq.size() * 100 / array.length));
    }
}
