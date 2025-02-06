package study.Record;

public record Toto() {
    Record Record() {
        return new Toto();
    }
}
