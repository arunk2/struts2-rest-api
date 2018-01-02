package com.ppltech.rest;

import java.io.IOException;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.BinaryConnectionFactory;
import net.spy.memcached.MemcachedClient;
 
public class MemCache {
    private static final String NAMESPACE= "VIEWER:";
    private static MemCache instance = null;
    private static MemcachedClient[] m = null;
     
    private MemCache() throws IOException {
        this.m = new MemcachedClient[20];
        for(int i = 0; i < 20; i++) {
        	m[i] =  new MemcachedClient(new BinaryConnectionFactory(),
					AddrUtil.getAddresses("127.0.0.1:11211"));
        }
    }
     
    public static synchronized MemCache getInstance() throws IOException {
        System.out.println("Instance: " + instance);
        if(instance == null) {
            System.out.println("Creating a new instance");
            instance = new MemCache();
         }
         return instance;
    }
     
    public void set(String key, int ttl, final Object o) {
        getCache().set(NAMESPACE + key, ttl, o);
    }
     
    public Object get(String key) {
        Object o = getCache().get(NAMESPACE + key);
        if(o == null) {
            System.out.println("Cache MISS for KEY: " + key);
        } else {
            System.out.println("Cache HIT for KEY: " + key);
        }
        return o;
    }
     
    public Object delete(String key) {
        return getCache().delete(NAMESPACE + key);  
    }
     
     
    public MemcachedClient getCache() {
        MemcachedClient c= null;
        try {
            int i = (int) (Math.random()* 20);
            c = m[i];
        } catch(Exception e) {
             e.printStackTrace();
        }
        return c;
    }
}
