import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class HomeWork4 {
    public static void main(String[] args) {
        // Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
        // 1) Умножьте два числа и верните произведение в виде связанного списка.
        // 2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными.

        Deque<Integer> myDeque1 = inputDeque(1);
        System.out.println("Первый дек: "+myDeque1);
        //Deque<Integer> myDeque2 = inputDeque(2);
        Deque<Integer> myDeque2 = myDeque1;
        System.out.println("Второй дек: "+myDeque2);
        System.out.println("Результат умножения: "+Operation(myDeque1, myDeque2,"mult"));
        System.out.println("Результат сложения: "+Operation(myDeque1, myDeque2, "sum"));
    }

    static Deque<Integer> inputDeque(int n){
        Scanner input = new Scanner(System.in);
        System.out.println("Для дека "+n+" введите нескольки цифр через пробел. Одно или два числа должны быть отрицательными.");
        String data = input.nextLine();
        if (data.indexOf("-") == -1){
            System.out.println("Одно или два числа должны быть отрицательными...");
            System.exit(0);
        }
        String[] tempArray = data.split(" ");
        Deque<Integer> myDeque = new LinkedList<>();
        for (String item : tempArray){
            // "каждый из их узлов содержит одну цифру"
            if (Math.abs(Integer.parseInt(item)) > 9)
                System.out.println("Используются слишком большие числа, но мы попробуем дальше без них...");
            // "Цифры хранятся в обратном порядке"
            myDeque.addLast(Integer.parseInt(item));
        }
        input.close();
        return(myDeque);
    }

    static LinkedList<Integer> Operation (Deque<Integer> a, Deque<Integer> b, String operation){// Пробовал для operation указать значение по умолчанию, но, видимо, Java так "не умеет" :-(
        // "верните произведение в виде связанного списка"
        LinkedList<Integer> myList = new LinkedList<>();
        while ((a.size() > 0) && (b.size() > 0)){
            if (operation=="mult")
                myList.add(a.pop()*b.pop());// "Цифры хранятся в обратном порядке"
            else
                myList.add(a.pop()+b.pop());// "Цифры хранятся в обратном порядке"
        }
        return(myList);
    }

}
