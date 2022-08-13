# Problem Statement

Design a Cache System with the following operations -

1. Put : Insert a value in the cache
2. Get : Fetch a value from the cache
3. Evict : Remove a value from the cache

# Design Expectations

* Modular and Readable Code - Following OOPS Principles and Design Patterns
* Extensible Code - adding new cache/policy should be as easy as possible
* Scalable and fast - Constant time operations if possible
* Functional Correctness (Caching should work as expected) - adding an element should not fail and eviction should work fine


# Designing a cache

1. Cache is a storage layer that is used to reduce the number of queries/query time from the Database. Hence it needs to be ultra-fast i.e. much faster than the DB query time. We expect time complexity of all operations to be O(1).
2. To reduce search time in cache, we have to keep it as small as possible. Hence, it needs to have a fixed capacity. Two cases arise from here -
   1. Size of cache < Capacity => Keep adding elements to cache
   2. Size of cache == Capacity => Remove element and then insert new element

*How do we decide which element to remove?* => Eviction Policy/Algorithm

3. Eviction Policy is the rule followed for removing elements from the cache once it reaches a desired capacity. Since cache data is supposed to be accessed very frequently, the most common way is the remove the least recently used data (LRU Cache).