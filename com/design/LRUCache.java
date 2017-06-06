package com.design;
import java.util.*;
/**
 * Created by swapn on 12/26/2016.
 */
public class LRUCache {

    public static void main(String[] args){
        LRUCache cache = new LRUCache(1);
        cache.set(2,1);
        System.out.println(cache.get(2));
    }

    private static class LRUNode{
        LRUNode next;
        LRUNode prev;
        int value;
        int key;

        public LRUNode(int key, int val){
            this.key = key;
            value = val;
            next = null;
            prev = null;
        }

    }

    Map<Integer, LRUNode> map;
    int capacity;
    LRUNode head;
    LRUNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new LRUNode(-1,-1);
        head.prev = null;
        tail = new LRUNode(-1,-1);
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            LRUNode val = map.get(key);
            moveToHead(val);
            return val.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            LRUNode val = map.get(key);
            val.value = value;
            moveToHead(val);
        }else{
            LRUNode temp = new LRUNode(key, value);
            map.put(key, temp);
            addNode(temp);
            capacity--;
            if(capacity < 0){
                LRUNode keyNode = deleteFromTail();
                map.remove(keyNode.key);
                capacity++;
            }
        }
    }

    private LRUNode deleteFromTail(){
        LRUNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void addNode(LRUNode link){
        link.next = head.next;
        link.prev = head;
        head.next = link;
        link.next.prev = link;
    }

    private void removeNode(LRUNode node){
        LRUNode pre = node.prev;
        LRUNode post = node.next;
        pre.next = post;
        post.prev = pre;
    }

    private void moveToHead(LRUNode node){
        this.removeNode(node);
        this.addNode(node);
    }
}
