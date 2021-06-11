package com.codegym.task.task37.task3708.retrievers;

import com.codegym.task.task37.task3708.cache.LRUCache;
import com.codegym.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private Storage storage;
    private LRUCache<Long, Object> lruCache;
    private OriginalRetriever originalRetriever;


    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        this.originalRetriever = new OriginalRetriever(storage);
        lruCache = new LRUCache<>(16);
    }

    @Override
    public Object retrieve(long id) {
        Object result = lruCache.find(id);
        if (result == null) {
            result = originalRetriever.retrieve(id);
            lruCache.set(id, result);
        }
        return result;
    }

}
