package com.codegym.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Serializable, Cloneable {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;
    private int capacity;
    private float loadFactor;
    private Set<E> set;

    public AmigoSet() {
        this.map = new HashMap();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int) (Math.ceil(collection.size() / .75f)));
        this.map = new HashMap<>(capacity);
        for (E e: collection
             ) {
            map.put(e, PRESENT);
        }
    }





    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean contains(Object o) {
        return this.map.containsKey(o);
    }

    public boolean add(E e) {
        return this.map.put(e, PRESENT) == null;
    }

    public boolean remove(Object o) {
        return this.map.remove(o) == PRESENT;
    }

    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        AmigoSet<E> clone;
        try {
            clone = (AmigoSet<E>) super.clone();
            clone.map = (HashMap) map.clone();
        } catch (Exception e) {
            throw new InternalError(e);
        }
        return clone;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        set = new HashSet<>();
        set.addAll(map.keySet());
        oos.defaultWriteObject();
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        map = new HashMap<>(capacity, loadFactor);
        for (E e: set
        ) {
            map.put(e, PRESENT);
        }
    }
}
