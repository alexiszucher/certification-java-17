package AnonymousClass;

public class Addition {
    private int a, b;
    abstract class Calculator {
        abstract int compute(int a, int b);
    }

    public Addition(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int add() {
        Calculator calculator = new Calculator() {
            public int compute(int a, int b) {
                return a + b;
            }
        };
        return calculator.compute(a, b);
    }
}
