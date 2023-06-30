import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class HomeWork2 {
    public static void main(String[] args) throws SecurityException, IOException {
        // Task1();
        // Task2();
        // Дополнительные задачки явно интересные, но не успеваю из-за очень странного расписания занятий - четыре занятия стартуют в течение двух минут :-(
    }

    // 1) Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
    // 1 Расширение файла: txt
    // 2 Расширение файла: pdf
    // 3 Расширение файла:
    // 4 Расширение файла: jpg
    static void Task1() {
        String[] files = Seminar2.showCurrentFiles(System.getProperty("user.dir"));
        for (int i = 0; i < files.length; i++) {
            System.out.printf("%d Расширение файла: %s\n",i+1,getExtension(files[i]));
        }
    }

    public static String getExtension(String fileName) {
        int index = fileName.lastIndexOf(".");
        if (index >= 0)
            return fileName.substring(index+1);
        return "";
    }

    // 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
    static void Task2() throws SecurityException, IOException{
        int[] array = {1,5,9,7,5,3,2,8,6,4};
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
                sortLog(array);
            }
        }
    }

    static void sortLog(int[] array) throws SecurityException, IOException{
        Logger logger = Logger.getLogger(Seminar2.class.getName());
        // В строке ниже указывается имя файла для логирования или что-то другое?
        // Каждый раз создаётся новый файл с похожим, но другим названием...
        FileHandler fh = new FileHandler("2-2.log");
        logger.addHandler(fh);
        SimpleFormatter simple = new SimpleFormatter();
        fh.setFormatter(simple);
        // Видимо, я что-то не понял про логирование, т.к. в лог пишется не массив :-(
        logger.warning(array.toString());
    }
}
