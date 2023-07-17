import java.util.Random;

public class HomeWork6 {
    public static void main(String[] args) {
        Random rnd = new Random();
        Cat Tom = new Cat("Tom", 0, 0, 0);
        Tom.Walk(rnd.nextInt(Cat.maxSpeed), rnd.nextInt(Cat.maxSpeed));
        Tom.Jump(rnd.nextInt(Cat.maxHeight));
        Cat Felix = new Cat("Felix", 100, 100, -10);
        Felix.Walk(rnd.nextInt(Cat.maxSpeed), rnd.nextInt(Cat.maxSpeed));
        Felix.Jump(rnd.nextInt(Cat.maxHeight));
    }
}
