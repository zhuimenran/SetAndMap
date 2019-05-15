package com.txb.hashtable;

import java.util.TreeMap;

public class HashTable<K, V> {
    //平均每个地址hash冲突的上界，超过这个上界，就需要扩容
    private static final int upperTol = 10;
    //平均每个地址hash冲突的下界，低于这个下界，就需要缩容
    private static final int lowerTol = 2;

    //初始化的时候hashtbale的容量
    private int capacityIndex = 0;

    private final int[] capacity = {53, 97, 197, 389, 769, 1543, 3079, 6151, 12289};


    private TreeMap<K, V>[] hashTable;
    private int M;//数组的长度
    private int size;//hash 表的长度

    public HashTable() {
        M = capacity[capacityIndex];
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    private int hash(K k) {
        //& 0x7fffffff 其实就是把hashcode转换成正数，然后再求余
        return (k.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }


    public void add(K key, V value) {
        //先计算key对应的hash值，然后根据该hash值得到在hashtable 中对应的TreeMap
        TreeMap<K, V> map = hashTable[hash(key)];
        //判断这个TreeMap是否包含这个key
        if (map.containsKey(key)) {
            //包含这个key,则说明是修改
            map.put(key, value);
        } else {
            //说明是添加，
            map.put(key, value);
            //维持一下size的值
            size++;
            if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
    }


    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            //存在相应的key,那么取出来这个值，然后维护一下size
            ret = map.get(key);
            size--;
            if (size < lowerTol * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;
    }


    public void set(K key, V value) {
        //先计算key对应的hash值，然后根据该hash值得到在hashtable 中对应的TreeMap
        TreeMap<K, V> map = hashTable[hash(key)];
        //判断这个TreeMap是否包含这个key
        if (map.containsKey(key)) {
            //包含这个key,则说明是修改
            map.put(key, value);
        } else {
            throw new IllegalArgumentException(key + "does not exist");
        }
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        int oldM = M;//保存之前的容量M
        //更新容量大小
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> treeMap = hashTable[i];
            for (K key : treeMap.keySet()) {
                newHashTable[hash(key)].put(key, treeMap.get(key));
            }
        }
        this.hashTable = newHashTable;
    }
}
