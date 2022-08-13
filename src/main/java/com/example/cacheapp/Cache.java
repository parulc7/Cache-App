package com.example.cacheapp;

import com.example.cacheapp.exceptions.KeyNotFoundException;
import com.example.cacheapp.exceptions.StorageFullException;
import com.example.cacheapp.policy.EvictionPolicy;
import com.example.cacheapp.storage.Storage;

public class Cache<Key, Value>{
    private EvictionPolicy<Key> evictionPolicy;
    private Storage<Key, Value> storage;

    public Cache(EvictionPolicy policy, Storage storageType){
        this.evictionPolicy = policy;
        this.storage = storageType;
    }

    void add(Key key, Value value){
        try{
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException e){
            System.out.println("Storage is Full. Will try to evict key..");
            Key keyToBeEvicted = this.evictionPolicy.evictKey();
            if(keyToBeEvicted==null){
                throw new RuntimeException("Unexpected State. Storage Full and no key to be evicted.");
            }
            this.storage.remove(keyToBeEvicted);
            add(key, value);
        }
    }

    void remove(Key key){
        this.storage.remove(key);
    }

    Value get(Key key){
        try{
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch(KeyNotFoundException e){
            System.out.println("Key not found in the storage.");
            return null;
        }
    }
}
