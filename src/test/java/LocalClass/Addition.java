package LocalClass;

public class Addition {
    private int a, b;
    public Addition(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int compute() {
        class Calculator {
            int compute(int a, int b) {
                return a + b;
            }
        }
        Calculator calculator = new Calculator();
        return calculator.compute(a, b);
    }
}
