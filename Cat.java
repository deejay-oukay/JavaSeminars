import java.util.LinkedList;

public class Cat {
    private int positionX;
    private int positionY;
    private int positionZ;
    private String petsname;
    static public int maxSpeed = 20;
    static public int maxHeight = 5;
    private int weigth;
    private int height;
    private Boolean sex;
    private LinkedList<String> vaccinations;
    private String[] diseases;
    private String[] awards;
    private String breed;

    public Cat(String name, int startX, int startY, int startZ) {
        this.petsname = name;
        this.positionX = startX;
        this.positionY = startY;
        this.positionZ = startZ;
        this.Status("Создание");
    }

    public void Walk(int deltaX, int deltaY) {
        this.positionX += deltaX;
        this.positionY += deltaY;
        this.Status("Движение в плоскости (" + deltaX + "," + deltaY + ")");
    }

    public void Jump(int deltaZ) {
        this.positionZ += deltaZ;
        this.Status("Прыжок (" + deltaZ + ")");
    }

    public void Status(String action) {
        System.out.printf("%s - %s. x: %d, y: %d, z: %d\n", this.petsname, action, this.positionX, this.positionY,
                this.positionZ);
    }

    public boolean vaccinationExists(String name) {
        try {
            if (this.vaccinations.contains(name))
                return (true);
        } catch (Exception e) {
            System.out.printf("Что-то не так с проверкой на наличие привики '%s' у кота %s\n", name, this.petsname);
            return (false);
        }
        return (false);
    }

    public void vaccinationAdd(String name) {
        try {
            this.vaccinations.add(name);
            System.out.printf("Прививка '%s' для кота %s сделана\n", name, this.petsname);
        } catch (Exception e) {
            System.out.printf("Кот %s не дал поставить прививку '%s'\n", this.petsname, name);
        }
    }

    public void vaccinationsList() {
        System.out.printf("Прививки кота %s:\n", this.petsname);
        System.out.println(this.vaccinations);
    }
}
