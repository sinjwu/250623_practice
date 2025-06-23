class Calculator {
    /**
     * @deprecated Use {@link #addNumber(int, int)} instead.
     */
    public int add(int a, int b) {
        return a + b;
    }
    //실행은 되나 경고가 뜸
    public int addNumber(int a, int b) {
        return a + b;
    }
}

public class MainDepctd {
    public static void main(String[] args) {
        Calculator ccltr = new Calculator();
        System.out.println(ccltr.add(1,2));
        System.out.println(ccltr.addNumber(3, 5));
    }
}
