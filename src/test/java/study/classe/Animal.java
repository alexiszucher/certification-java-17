package study.classe;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private List<String> animals;

    public Animal() {
        this(new ArrayList<>());
        animals = new ArrayList<>();
        animals.add("Dog");
    }

    public Animal(List<String> animals) {
        this.animals = animals;
    }

    public List<String> animals() {
        return animals;
    }
}
