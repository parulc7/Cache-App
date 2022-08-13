package com.example.cacheapp.policy;

import java.util.*;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{

    private Deque<Key> queue;
    private HashSet<Key> map;

    public LRUEvictionPolicy(){
        this.queue = new ArrayDeque<>();
        this.map = new HashSet<>();
    }

    @Override
    public void keyAccessed(Key key){
        if(map.contains(key)){
            queue.remove(key);
            queue.addFirst(key);
        }else{
            queue.addFirst(key);
            map.add(key);
        }
    }

    @Override
    public Key evictKey(){
        Key last = queue.removeLast();
        if(last==null){
            return null;
        }
        map.remove(last);
        return last;
    }
}
