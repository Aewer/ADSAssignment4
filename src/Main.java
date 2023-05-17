public class Main {
    public static void main(String[] args) {
        MyHashTable<Object, Object> table = new MyHashTable<>();
        table.put("A", 1);
        table.put("B", 2);
        table.put("C", 3);
        table.put("D", 4);

        System.out.println("Value of A: " + table.get("A"));
        System.out.println("Value of 1: " + table.get("1"));
        System.out.println("Value of C: " + table.get("C"));
        //table.remove("A");
        System.out.println("Value of D: " + table.get("D"));
        System.out.println("Size:" + table.size);
        System.out.println("Key of value 4 is " + table.getKey(4));
        System.out.println("Contains value 3: " + table.contains(3));
    }
}