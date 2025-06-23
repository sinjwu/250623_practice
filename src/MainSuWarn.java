public class MainSuWarn {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        java.util.List<String> list = new java.util.ArrayList();
        list.add("Hello");
        list.add("World");
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}

