import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        Task1();
        //Task2();
        //Task3();
    }

    //1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
    static void Task1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите n");
        Integer n = sc.nextInt();
        System.out.printf("Треугольное число: %d\nФакториал: %d",TriangleNumber(n),Factorial(n));
        sc.close();
    }

    static int TriangleNumber(int n){
        return(n * (n + 1)) / 2;
    }

    static int Factorial(int n){
        Integer factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return(factorial);
    }
    
    //2) Вывести все простые числа от 1 до 1000
    static void Task2() {
        for (int i = 1; i <= 1000; i++) {
            Boolean isPrime = true;
            for (int j = 2; j < i; j++)
                if (i % j == 0){
                    isPrime = false;
                    break;
                }
            if (isPrime)
                System.out.print(i+" ");
        }
    }

    //3) Реализовать простой калькулятор
    static void Task3() {
        Scanner scI = new Scanner(System.in);
        Scanner scS = new Scanner(System.in); //почему-то не получилось использовать один и тот же объект для ввода и числе и строк
        System.out.println("Введите первое число");
        Integer number1 = scI.nextInt();
        System.out.println("Введите оператор: +, -, *, /");
        String operator = scS.nextLine();
        System.out.println("Введите второе число");
        Integer number2 = scI.nextInt();
        scI.close();
        scS.close();
        switch (operator) {
            case "+":
                System.out.printf("%d %s %d = %d", number1, operator, number2, number1+number2);
                break;
            case "-":
                System.out.printf("%d %s %d = %d", number1, operator, number2, number1-number2);
                break;
            case "*":
                System.out.printf("%d %s %d = %d", number1, operator, number2, number1*number2);
                break;
            case "/":
                System.out.printf("%d %s %d = %f", number1, operator, number2, (float)number1/(float)number2);
                break;
            default:
                System.out.println("Калькулятор сломался :-(");
                break;
        }
    }

    /*4) (дополнительное задание)
    Задано уравнение вида q + w = e, q, w, e >= 0.
    Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
    Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
    */

    /*
    https://www.youtube.com/watch?v=UYLoeEuBcpc
    */
}
