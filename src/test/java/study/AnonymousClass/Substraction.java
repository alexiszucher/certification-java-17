package study.AnonymousClass;

public class Substraction {
    private int a, b;

    public Substraction(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int substract() {
        Substraction.Calculator calculator = new Substraction.Calculator() {
            public int compute(int a, int b) {
                return a - b;
            }
        };
        return calculator.compute(a, b);
    }

    abstract interface Calculator {
        abstract int compute(int a, int b);
    }
}
