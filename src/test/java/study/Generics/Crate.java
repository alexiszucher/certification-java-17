package study.Generics;

public class Crate<T> {
    private T content;

    public Crate(T content) {
        this.content = content;
    }

    public T content() {
        return content;
    }

    public <T> T showGeneric(T content) {
        return content;
    }
}
