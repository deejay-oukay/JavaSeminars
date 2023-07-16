import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class HomeWork5 {
    // Реализуйте структуру телефонной книги с помощью HashMap.
    // Программа также должна учитывать, что во входной структуре будут
    // повторяющиеся имена с разными телефонами, их необходимо считать, как одного
    // человека с разными телефонами. Вывод должен быть отсортирован по убыванию
    // числа телефонов.

    static Map<String, String> options = new HashMap<>();
    static Map<String, LinkedList<String>> contacts = new HashMap<>();
    static String whatToDo = "";
    static int max = 0;

    public static void main(String[] args) {
        options.put("add", "Добавить данные");
        options.put("edit", "Изменить данные");
        options.put("del", "Удалить данные");
        options.put("print", "Вывести данные");
        options.put("exit", "Выйти");
        optionsList();
    }

    static void optionsList() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("---");
            for (Map.Entry<String, String> option : options.entrySet()) {
                System.out.printf("%s - %s\n", option.getKey(), option.getValue());
            }
            System.out.println("---\nЧто нужно сделать? ");
            whatToDo = input.nextLine();
            /*
             * Хотел использовать что-то вроде whatToDo+"Data"(), но не понял, как это
             * сделать. В PHP, например, бывает удобно использовать имена методов,
             * хранящиеся в переменных
             * if (options.containsKey(whatToDo)) {}
             */
            switch (whatToDo) {
                case "add":
                    addData();
                    break;
                case "edit":
                    editData();
                    break;
                case "del":
                    delData();
                    break;
                case "print":
                    printData();
                    break;
            }
        } while (!whatToDo.equals("exit"));
        input.close();
    }

    static String inputString(String message) {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s: ", message);
        // input.close(); - вызывало ошибку при втором вызове метода, но не при первом
        return (input.nextLine());
    }

    static void addData() {
        clearScreen();
        String name = inputString("Введите имя");
        if (!contacts.containsKey(name))
            contacts.put(name, new LinkedList<>());
        String phone = inputString("Введите телефон");
        if (!contacts.get(name).contains(phone))
            contacts.get(name).add(phone);
        if (contacts.get(name).size() > max)
            max = contacts.get(name).size();
    }

    static void editData() {
        printData();
        String name = inputString("Введите имя, для которого нужно изменить телефон");
        if (contacts.containsKey(name)) {
            String phone = inputString("Введите телефон, который нужно изменить");
            if (contacts.get(name).contains(phone)) {
                contacts.get(name).remove(phone);
                contacts.get(name).add(inputString("Введите новый телефон"));
            } else
                System.out.println("Номер не найден");
        } else
            System.out.println("Имя не найдено");
    }

    static void delData() {
        printData();
        String name = inputString("Введите имя, для которого нужно удалить телефон");
        if (contacts.containsKey(name)) {
            String phone = inputString("Введите телефон, который нужно удалить");
            if (contacts.get(name).contains(phone)) {
                contacts.get(name).remove(phone);
                if (contacts.get(name).size() == 0)
                    contacts.remove(name);
            } else
                System.out.println("Номер не найден");
        } else
            System.out.println("Имя не найдено");
    }

    static void printData() {
        clearScreen();
        int i = max;
        while (i > 0) {
            for (var contact : contacts.entrySet()) {
                if (contact.getValue().size() == i)
                    System.out.println(contact);
            }
            i--;
        }

    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
