package classe.override;

public class Fish {
    protected int speed = 1;

    public static String name() {
        return "Fish";
    }

    public String swim() {
        return "Fish swim";
    }

    public int getSpeed() {
        return speed;
    }

    private void toto() {
        System.out.println("Toto");
    }
}
