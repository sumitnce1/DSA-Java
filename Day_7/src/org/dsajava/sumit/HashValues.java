package org.dsajava.sumit;

public class HashValues<K, V> {

    public static class KeyValues<K, V> {
        K key;
        V value;

        public KeyValues(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static final int DEF_CAPACITY = 100;

    public int capacity;
    private KeyValues<K, V>[] table;

    public HashValues() {
        this.capacity = DEF_CAPACITY;
        this.table = new KeyValues[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    // insert into hash table
    public void put(K key, V value) {
        int index = hash(key);
        KeyValues<K, V> pair = new KeyValues<>(key, value);

        if (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index].value = value;
                return;
            }
            int newIndex = (index + 1) % capacity;
            while (newIndex != index) {
                if (table[newIndex] == null) {
                    table[newIndex] = pair;
                    return;
                }
                if (table[newIndex].key.equals(key)) {
                    table[newIndex].value = value;
                    return;
                }
                newIndex = (newIndex + 1) % capacity;
            }
        }
        table[index] = pair;
    }

    // fetch element
    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            int newIndex = (index + 1) % capacity;
            while (newIndex != index) {
                if (table[newIndex] == null) {
                    break;
                }
                if (table[newIndex].key.equals(key)) {
                    return table[newIndex].value;
                }
                newIndex = (newIndex + 1) % capacity;
            }
        }
        return null;
    }

    // delete an element
    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index] = null;
            } else {
                int nextIndex = (index + 1) % capacity;
                while (table[nextIndex] != null) {
                    int newIndex = hash(table[nextIndex].key);
                    if ((nextIndex > index && (newIndex <= index || newIndex > nextIndex))
                            || (nextIndex < index && newIndex <= index)) {
                        table[index] = table[nextIndex];
                        table[nextIndex] = null;
                        index = nextIndex;
                    }
                    nextIndex = (nextIndex + 1) % capacity;
                }
            }
        }
    }

    public static void main(String[] args) {
        HashValues<String, Integer> hashTable = new HashValues<>();
        hashTable.put("India", 1);
        hashTable.put("Canada", 2);
        hashTable.put("Australia", 3);

        System.out.println("Values \"India\": " + hashTable.get("India"));
        System.out.println("Values \"Canada\": " + hashTable.get("Canada"));
        System.out.println("Values \"Australia\": " + hashTable.get("Australia"));

        hashTable.remove("Australia");
        System.out.println("Values \"Australia\": " + hashTable.get("Australia"));
    }
}
