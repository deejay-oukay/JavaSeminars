import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.Iterator;
import java.util.List;

public class Seminar3 {
    public static void main(String[] args) {
        //listCreation(10);
        //randomNumbers(5,10);
        //sunSystem(15);
        //planetsCounter(7);
        createTable(3);
    }

    //Заполнить список 10-ю случайными числами
    //Отсортировать список методом sort и вывести его на экран
    public static void listCreation(int listLength) {
        ArrayList<Double> arrayList = new ArrayList<Double>();
        System.out.println("Изначальный список:");
        for (int i = 0; i < listLength; i++) {
            arrayList.add(Math.random());
            System.out.println(arrayList.get(arrayList.size()-1));
        }
        Collections.sort(arrayList);
        System.out.println("\nОтсортированный список:");
        for (Double iter : arrayList) {
            System.out.println(iter +" ");
        }
    }

    //Вариант преподавателя
    static void randomNumbers(int size, int maxValue) {
        ArrayList<Integer> nums = new ArrayList<>(size);
        Random rand = new Random();        
        for (int i = 0; i < size; i++)
            nums.add(rand.nextInt(maxValue));
        for (Integer num : nums)
            System.out.print(num+" ");
        System.out.println();
        nums.sort(Comparator.naturalOrder());
        Iterator<Integer> iter = nums.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next()+" ");
        }
    }

    //Необходимо заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями
    //Вывести название каждой планеты и количество его повторений в списке
    public static void sunSystem(int listLength){
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
    }

    //Вариант преподавателя
    static void planetsCounter(int n){
        List<String> listPlanets = List.of("Меркурий","Венера","Земля","Марс","Юпитер","Сатурн","Уран","Нептун");
        List<String> randPlanets = new ArrayList<String>(n);
        int[] counts = new int[listPlanets.size()];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            randPlanets.add(listPlanets.get(rand.nextInt(listPlanets.size())));
            System.out.print(randPlanets.get(i)+" ");
            counts[listPlanets.indexOf(randPlanets.get(i))]++;
        }
        System.out.println();
        for (int i = 0; i < counts.length; i++)
            System.out.printf("%s - %s\n",listPlanets.get(i),counts[i]);
    }

    //Каталог товаров книжного магазина сохранён в виде двумерного списка List ArrayList String ()
    //!!ЕСЛИ СМОТРЕТЬ В ЗАПИСИ, ТО ОТ ЗАДАЧ В ЧАТЕ ТОЛКУ НЕТ (что слышу, то и пишу)!!!
    //Так, что на 0-ой позиции каждого внутреннего списка содержится название жанра, а на остальных позициях - названия книг.
    //Напишите метод для заполнения данной структуры
    static void createTable(int size){
        List<String> genres = List.of("Фантастика", "Комедия", "Детектив", "Ужасы");
        List<ArrayList<String>> table = new ArrayList<>(genres.size());
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < genres.size(); i++) {
            ArrayList<String> booksOfGenre = new ArrayList<>(size);
            booksOfGenre.add(genres.get(i));
            System.out.printf("Input %d titles of %s genre down here:\n",size,genres.get(i));
            for (int j = 0; j < size; j++)
                booksOfGenre.add(input.nextLine());
            table.add(booksOfGenre);
        }
        input.close();
        for (ArrayList<String> books : table) {
            for (String book : books) {
                System.out.print(book+" ");
            }
            System.out.println();
        }
    }
}
