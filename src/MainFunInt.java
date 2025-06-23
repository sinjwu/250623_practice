@FunctionalInterface
interface Greeting {
    void sayHello(String name);
    //void anotherMethod():
}
public class MainFunInt {
    public static void main(String[] args) {
        Greeting greet = (name) -> System.out.println("Hello, " + name + "!");
        greet.sayHello("Alice");
    }
}
