package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        MyMap<Integer, String> myHashMap = new MyHashMap<>();

        myHashMap.put(null, "Artem");
        System.out.println(myHashMap.getValue(null));
    }
}
