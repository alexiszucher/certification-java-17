package classe.override;

public class Shark extends Fish {
    protected int speed = 2;

    int toto() {
        return 1;
    }


    @Override
    public String swim() {
        return "Shark swim";
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
