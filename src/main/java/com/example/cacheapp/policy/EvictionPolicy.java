package com.example.cacheapp.policy;

public interface EvictionPolicy<Key> {

    void keyAccessed(Key key);

    Key evictKey();
}
