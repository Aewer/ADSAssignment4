public class Main {
    public static void main(String[] args) {
        MyHashTable<Object, Object> table = new MyHashTable<>();
        table.put("A", 31);
        table.put("B", 32);
        table.put("C", 33);
        table.put("A", 32);

        System.out.println("Value of A: " + table.get("A"));
        System.out.println("Value of 1: " + table.get("1"));
        System.out.println("Value of C: " + table.get("C"));
        table.remove("A");
        System.out.println("Value of D: " + table.get("D"));
    }
}