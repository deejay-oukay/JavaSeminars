import java.util.Scanner;
import java.time.LocalDateTime;

public class Seminar1{
    public static void main(String[] args) {
        //helloUser();
        //quantityOfSame();
        //magicIndex();
        reversePhrase();
    }

    static void helloUser(){
        Scanner sc = new Scanner(System.in);
        int hour = LocalDateTime.now().getHour();
        System.out.println("What's your name?");
        String name = sc.nextLine();
        String dateTime = "";
        if ((hour >= 4) && (hour < 11))
            dateTime = "morning";
        else if ((hour >= 11) && (hour < 17))
            dateTime = "day";
        else if ((hour >= 17) && (hour < 23))
            dateTime = "evening";
        else
            dateTime = "night";
        System.out.printf("Good %s, %s", dateTime, name);
        sc.close();
    }

    static void quantityOfSame() {
        int[] array = new int[] {1,1,0,1,1,1};
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1)
                count++;
            else if (count > maxCount)
            {
                maxCount = count;
                count = 0;
            }
            else
                count = 0;
        }
        if (count > maxCount)
            maxCount = count;
        System.out.println(maxCount);
    }

    static void magicIndex(){
        int[] array = new int[] {1,7,3,6,5,6};
        for (int i = 1; i < array.length-1; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for(int i1 = 0; i1 < i; i1++)
                leftSum += array[i1];
            for(int i2 = i+1; i2 < array.length; i2++)
                rightSum += array[i2];
            if (leftSum == rightSum)
            {
                System.out.println(i);
                return;
            }
        }
    }

    static void reversePhrase(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Input text");
        String phrase = sc.nextLine();
        String[] words = phrase.split(" ");
        String[] res = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            res[i] =   words[words.length - 1 - i];
        }
        for (String word : res) {
            System.out.print(word+" ");
        }
        sc.close();
    }
}
