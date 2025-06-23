import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ReflectionDemo2 {
    public String noSecret = "비밀 아님";
    private String secret = "비밀입니다.";
    public ReflectionDemo2() {
        System.out.println("ReflectionDemo2 생성자 실행");
    }
    public String greet(String name) {
        return "Hello, " + name;
    }
    private String reveal(String code) {
        return "Access granted to: " + code;
    }
}

public class Refl2 {
    public static void main(String[] args) {
        Class<?> clazz = ReflectionDemo.class;
        System.out.println("클래스 이름: " + clazz.getName());
        System.out.println("\n[필드 목록]");
        Field[] flds = clazz.getDeclaredFields();
        for(Field fld: flds) {
            System.out.println("필드: " + fld.getName());
        }
        System.out.println("\n[메소드 목록]");
        Method[] mthds = clazz.getDeclaredMethods();
        for(Method mthd: mthds) {
            System.out.println("메소드: " + mthd.getName());
            for(Class<?> paramType: mthd.getParameterTypes()) {
                System.out.println("파라미터 타입: " + paramType.getSimpleName());
            }
        }
    }
}
