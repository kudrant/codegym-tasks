package com.codegym.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return values().size();
        //write your code here
    }

    @Override
    public V put(K key, V value) {
        //write your code here
        List<V> values = map.get(key);
        V lastValue = null;
        if (values == null)
            values = new ArrayList<>();
        else {
            lastValue = values.get(values.size() - 1);
            if (values.size() == repeatCount)
                values.remove(0);
        }
        values.add(value);
        map.put(key, values);

        return lastValue;
    }


    @Override
    public V remove(Object key) {
        //write your code here
        if (!map.containsKey(key))
            return null;
        List<V> values = map.get(key);
        V returnValue = values.get(0);
        values.remove(0);
        if (values.isEmpty()) {
            map.remove(key);
        }
        return returnValue;
    }

    @Override
    public Set<K> keySet() {
        //write your code here
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //write your code here
        ArrayList<V> values = new ArrayList<>();
        for (List<V> value: map.values()) {
            values.addAll(value);
        }
        return values;
    }

    @Override
    public boolean containsKey(Object key) {
        //write your code here
        return map.keySet().contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //write your code here
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}