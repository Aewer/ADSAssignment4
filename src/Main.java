public class Main {
    public static void main(String[] args) {
        MyHashTable<Object, Object> table = new MyHashTable<>();
        table.put("A", 1);
        table.put("B", 2);
        table.put("C", 3);
        table.put("D", 4);

        System.out.println("Value of A: " + table.get("A"));
        System.out.println("Value of B: " + table.get("B"));
        System.out.println("Value of C: " + table.get("C"));
        System.out.println("Value of D: " + table.get("D"));
        table.remove("C");
        table.replace("A", 1, 5);
        table.replace("B", 2, 10);
        table.replace("D", 4, 18);
        System.out.println("Replaced value of A: " + table.get("A"));
        System.out.println("Replaced value of B: " + table.get("B"));
        System.out.println("Replaced value of D: " + table.get("D"));
        System.out.println("Removed value of C: " + table.get("C"));
        System.out.println("Size:" + table.size);
        System.out.println("Key of value 5 is " + table.getKey(5));
        System.out.println("Contains value 3: " + table.contains(3));
    }
}