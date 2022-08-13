package com.example.cacheapp.factory;

import com.example.cacheapp.Cache;
import com.example.cacheapp.policy.LRUEvictionPolicy;
import com.example.cacheapp.storage.HashSetBasedStorage;

// Factory object to store all cache types
public class CacheFactory<Key, Value> {

    // LRU Cache default implementation
    public Cache<Key, Value> defaultCache(int capacity){
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(), new HashSetBasedStorage<Key, Value>(capacity));
    }
}
