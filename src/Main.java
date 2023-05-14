public class Main {
    public static void main(String[] args) {
        MyHashTable<Object, Object> table = new MyHashTable<>();
        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            table.put(key, key);
        }
    }
}