import java.lang.reflect.Field;

class ReflectionDemo {
    public String noSecret = "비밀 아님";
    private String secret = "비밀입니다.";
    public ReflectionDemo() {
        System.out.println("ReflectionDemo 생성자 실행");
    }
    public String greet(String name) {
        return "Hello, " + name;
    }
    private String reveal(String code) {
        return "Access granted to: " + code;
    }
}

public class MainReflection {
    public static void main(String[] args) {
        Class<?> clazz = ReflectionDemo.class;
        System.out.println("클래스 이름: " + clazz.getName());
        System.out.println("\n[필드 목록]");
        Field[] flds = clazz.getDeclaredFields();
        for(Field fld: flds) {
            System.out.println("필드: " + fld.getName());
        }
    }
}
