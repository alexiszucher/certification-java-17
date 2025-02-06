package study.Collection;

public class Animal implements Comparable<Animal> {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Animal o) {
        return this.name.compareTo(o.name);
    }

    public String name() {
        return name;
    }
}
