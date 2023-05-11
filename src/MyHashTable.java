public class MyHashTable<K, V> {
    private class HashNode<K, V> {

        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K, V>[] chainArray;
    private int M;
    private int size;
    public MyHashTable() {
        size = 0;
        M = 11;
    }
    public MyHashTable(int M) {
        size = 0;
        this.M = M;
    }
}
