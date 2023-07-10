import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Seminar4 {
    public static void main(String[] args) {
        //ex1();
        //ex2();
        ex3();
    }

    static void ex1(){
        ArrayList<Integer> al = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>();
        
        long start1 = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            al.add(5);
        }
        System.out.println(System.currentTimeMillis() - start1);
        
        long start2 = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            ll.add(5);
        }
        System.out.println(System.currentTimeMillis() - start2);
    }

    static void ex2(){
        LinkedList<String> myList = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        String data = "end";
        while(true) {
            System.out.printf("Input text~num, 0 <= num <= %d\n", myList.size());
            data = input.nextLine();
            if (data.equals("end"))
                break;
            changingList(myList, data);
            System.out.println(myList);
        }
    }

    static void changingList(LinkedList<String> myList, String data) {
        try {
            int index = Integer.parseInt(data.split("~")[1]);
            String text = data.split("~")[0];
            if (text.equals("print")){
                System.out.println(myList.get(index));
                myList.remove(index);
            }
            else 
                myList.add(index,text);

        } catch (Exception e) {
            System.out.println("You have to input a correct number!");
        }
    }

    static void ex3(){
        Deque<String> myList = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        String data = "end";
        while(true) {
            System.out.println("Input something or print or revert or end");
            data = input.nextLine();
            if (data.equals("end")){
                input.close();
                break;
            }
            changingList(myList, data);
            System.out.println(myList);
        }
    }

    static void changingList(Deque<String> myList, String data) {
        if(data.equals("print")){
            for (String item : myList)
                System.out.println(item);
        }
        else if (data.equals("revert"))
            myList.pollFirst();
        else
            myList.addFirst(data);

    }
}
