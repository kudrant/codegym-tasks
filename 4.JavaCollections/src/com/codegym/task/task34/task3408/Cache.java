package com.codegym.task.task34.task3408;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   // TODO: Add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (!cache.containsKey(key))
            cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key));

        return cache.get(key);

    }

    public boolean put(V obj) {
        // TODO: Add your code here
        Method refMethod = null;
        try {
            refMethod = obj.getClass().getDeclaredMethod("getKey");
            refMethod.setAccessible(true);

            cache.put((K) refMethod.invoke(obj), obj);
            return cache.containsKey((K) refMethod.invoke(obj));
        } catch (Exception e) {
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}