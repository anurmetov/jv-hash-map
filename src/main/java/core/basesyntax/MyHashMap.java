package core.basesyntax;

import java.util.Arrays;

public class MyHashMap<K, V> implements MyMap<K, V> {

    // TODO: Resize logic!!!
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<K,V>[] table;
    private int size; // Количество Нод елементов (количество ключ пара значения)
    private int threshold; // порог дает знать когда ресайзить table

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        this.table = (Node<K,V>[]) new Node[16];
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        Node<K,V> current = table[index];
        if (table[index] == null) {
            table[index] = new Node<>(key,value);
            size++;
            return;
        }

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }

            if (current.next == null) {
                current.next = new Node<>(key, value);
                size++;
                return;
            }
            current = current.next;
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public V getValue(K key) {

        return table[hash(key)].getValue();
    }

    @Override
    public int getSize() {
        return size;
    }

    // Індекс куда треба поставити значення
    private int hash(K key) {
        int hash;
        return (key == null) ? 0 : (hash = key.hashCode() % DEFAULT_CAPACITY);
    }

    static class Node<K,V> {
        private Node<K,V> next;
        private K key;
        private V value;
        private int hash;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return (String) value;
        }
    }

    @Override
    public String toString() {
        return "MyHashMap{"
                + "table=" + Arrays.toString(table)
                + ", size="
                + size
                + ", threshold="
                + threshold
                + '}';
    }
}
