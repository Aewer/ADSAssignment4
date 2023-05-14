public class Main {
    public static void main(String[] args) {
        MyHashTable<Object, Object> table = new MyHashTable<>();
        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            table.put(key, key);
        }
        for (int i = 0; i < 30; i++) {
            System.out.println(table.get(i));
        }
        table.put("A", 31);
        table.put("B", 32);
        table.put("C", 33);

        System.out.println("Value of A: " + table.get("A"));
        System.out.println("Value of 1: " + table.get("1"));
        System.out.println("Value of 13: " + table.get("13"));
    }
}