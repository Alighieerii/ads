public class Main {
    public static void main(String[] args) {

        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>();

        for (int i = 0; i < 10000; i++) {
            table.put(new MyTestingClass(i, "name" + i), i);
        }

        table.printBuckets();
    }
}