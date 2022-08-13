package com.example.cacheapp.storage;

import com.example.cacheapp.datastructures.DoublyLinkedList;
import com.example.cacheapp.datastructures.DoublyLinkedListNode;

import java.util.HashMap;

public class HashSetBasedStorage<Key, Value> implements Storage<Key, Value>{
    private HashMap<Key, Value> cacheRegister;
    private final Integer capacity;

    public HashSetBasedStorage(Integer capacity){
        cacheRegister = new HashMap<>();
        this.capacity = capacity;
    }

    private boolean isStorageFull(){
        return (this.cacheRegister.size()==this.capacity);
    }

    @Override
    public void add(Key key, Value value){
        if(isStorageFull()){
            return;
        }
        this.cacheRegister.put(key, value);
    }

    @Override
    public void remove(Key key){
        if(this.cacheRegister.containsKey(key)){
            this.cacheRegister.remove(key);
        }
    }

    @Override
    public Value get(Key key){
        if(this.cacheRegister.containsKey(key)){
            return this.cacheRegister.get(key);
        }
        return null;
    }
}
