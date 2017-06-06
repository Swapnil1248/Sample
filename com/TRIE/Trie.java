package com.TRIE;
import java.util.*;
/**
 * Created by swapn on 11/23/2016.
 */

public class Trie {
    private class TrieNode {
        // Initialize your data structure here.
        char c;
        Map<Character, TrieNode> map;
        boolean isEnd;

        public TrieNode() {
            this.map = new HashMap<>();
            this.isEnd = false;
        }

        public TrieNode(char c) {
            this.c = c;
            this.map = new HashMap<>();
            this.isEnd = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] arr = word.toCharArray();
        TrieNode currNode = root;
        for(char c : arr){
            if(!currNode.map.containsKey(c)){
                currNode.map.put(c, new TrieNode(c));
            }
            currNode = currNode.map.get(c);
        }
        currNode.isEnd = true;
    }

    private TrieNode searchPrefix(String word) {
        char[] arr = word.toCharArray();
        TrieNode currNode = root;
        for(char c : arr){
            if (currNode.map.containsKey(c)) {
                currNode = currNode.map.get(c);
            } else {
                return null;
            }
        }
        return currNode;
    }


    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args){
        //PriorityQueue
         Trie trie = new Trie();
         trie.insert("somestring");
         System.out.println(trie.search("key"));
        trie.insert("ab");
        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("a"));
    }
}


