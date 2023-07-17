public class Cat {
    private int positionX = 0;
    private int positionY = 0;
    private int positionZ = 0;
    private String petsname;
    static public int maxSpeed = 20;
    static public int maxHeight = 5;

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
}
