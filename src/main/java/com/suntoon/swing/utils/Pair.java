package com.suntoon.swing.utils;

import java.util.Map;

/**
 * @Description 键值对对象
 * @Author ylf
 * @Date 2019/9/18 0018下午 3:29
 */
public class Pair<K,V> implements Map.Entry<K, V> {

    private K key;

    private V v;

    /**
     * 键值对对象
     * @param key
     * @param v
     */
    public Pair(K key,V v)
    {
        this.key = key;
        this.v = v;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public K getKey() {
        return this.key;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V getValue() {
        return this.v;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V setValue(V value) {
        this.v = value;
        return this.v;
    }

}

