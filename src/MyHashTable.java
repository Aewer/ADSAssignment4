import java.util.ArrayList;
import java.util.Objects;

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
    private ArrayList<HashNode<K, V>> chainArray;
    private int numberOfChains = 11;
    private int size;
    public MyHashTable() {
        chainArray = new ArrayList<>();
        size = 0;
        for (int i = 0; i < numberOfChains; i++)
            chainArray.add(null);
    }
    public MyHashTable(int numberOfChains) {
        chainArray = new ArrayList<>();
        size = 0;
        this.numberOfChains = numberOfChains;
        for (int i = 0; i < numberOfChains; i++)
            chainArray.add(null);
    }
    public int hash(K key) {
        return Objects.hashCode(key) % numberOfChains;
    }
    public void put(K key, V value) {
        int hash = hash(key);
        HashNode<K, V> hashNode = new HashNode<K, V>(key,value);
        if (chainArray.get(hash) == null) {
            chainArray.set(hash, hashNode);
        } else {
            HashNode temp = chainArray.get(hash);
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = hashNode;
        }
    }
}
