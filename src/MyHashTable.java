import java.util.ArrayList;
import java.util.Objects;

public class MyHashTable<K, V> {
    //HashNode is a key-value pair that references the next HashNode like a linked list
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;
        //Constructor
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        // toString returns the key-value pair in string format
        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }
    private ArrayList<HashNode<K, V>> chainArray;
    // default number of chains
    private int numberOfChains = 11;
    public int size;
    // Default constructor
    public MyHashTable() {
        chainArray = new ArrayList<>();
        size = 0;
        for (int i = 0; i < numberOfChains; i++)
            chainArray.add(null);
    }
    // Constructor with specified number of chains
    public MyHashTable(int numberOfChains) {
        chainArray = new ArrayList<>();
        size = 0;
        this.numberOfChains = numberOfChains;
        for (int i = 0; i < numberOfChains; i++)
            chainArray.add(null);
    }
    // hash method returns the hash value of the key
    public int hash(K key) {
        //System.out.println("Hash code of key " + key + " is " + Objects.hashCode(key) % numberOfChains);
        return Objects.hashCode(key) % numberOfChains;
    }
    // put method inserts a hash node into hash table.
    // If hash collision happens it inserts hash node into the next node of the chain array
    public void put(K key, V value) {
        int hash = hash(key);
        HashNode<K, V> newHashNode = new HashNode<K, V>(key,value);
        if (chainArray.get(hash) == null) {
            chainArray.set(hash, newHashNode);
            size++;
        } else {
            HashNode<K, V> temp = chainArray.get(hash);
            while(temp != null) {
                if (temp.key.equals(key)) {
                    temp.value = value;
                    return;
                }
                temp = temp.next;
            }
            temp.next = newHashNode;
            size++;
        }
    }
    // get method returns the value of entered key
    public V get(K key) {
        int hash = hash(key);
        if (chainArray.get(hash) != null) {
            HashNode<K, V> temp = chainArray.get(hash);
            while(!temp.key.equals(key) && temp.next != null) {
                temp = temp.next;
            }
            return temp.value;
        }
        return null;
    }
    // remove method deletes the key from hash table
    public V remove(K key) {
        int hash = hash(key);
        HashNode<K, V> temp = chainArray.get(hash);
        HashNode<K, V> prevTemp = null;
        while (temp != null) {
            if (temp.key.equals(key)) {
                break;
            }
            prevTemp = temp;
            temp = temp.next;
        }
        if (temp == null) {
            return null;
        }
        if (prevTemp != null) {
            prevTemp.next = temp.next;
        } else {
            chainArray.set(hash, temp.next);
        }
        size--;
        return temp.value;
    }
    public boolean contains(V value) {
        for (HashNode<K, V> temp : chainArray) {
            while (temp != null) {
                if (temp.value.equals(value)) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }
    // Returns the key corresponding to value
    public K getKey(V value) {
        for (HashNode<K, V> temp : chainArray) {
            while (temp != null) {
                if (temp.value.equals(value)) {
                    return temp.key;
                }
                temp = temp.next;
            }
        }
        return null;
    }
    public void replace(K key, V old_value, V new_value) {
        int hash = hash(key);
        HashNode<K, V> newHashNode = new HashNode<K, V>(key, new_value);
        if (chainArray.get(hash) == null) {
            chainArray.set(hash, newHashNode);
        }
        else {
            HashNode<K, V> temp = chainArray.get(hash);
            while (temp != null) {
                if (temp.key.equals(key)) {
                    temp.value = new_value;
                    break;
                }
                temp = temp.next;
            }
        }
    }
}
