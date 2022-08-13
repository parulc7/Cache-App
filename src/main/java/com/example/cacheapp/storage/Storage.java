package com.example.cacheapp.storage;

import com.example.cacheapp.exceptions.KeyNotFoundException;
import com.example.cacheapp.exceptions.StorageFullException;

// Class to define the storage interface
public interface Storage<Key, Value> {

    void add(Key key, Value value) throws StorageFullException;
    void remove(Key key) throws KeyNotFoundException;
    Value get(Key key) throws KeyNotFoundException;
}
