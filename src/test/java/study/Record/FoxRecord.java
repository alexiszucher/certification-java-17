package study.Record;

public record FoxRecord(String name) {
    public FoxRecord {
        name = name.toUpperCase();
    }

    public FoxRecord(String firstName, String lastName) {
        this(firstName + " " + lastName);
    }
}
