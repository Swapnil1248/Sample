package com.TRIE;

/**
 * Created by swapnil on 2/23/2017.
 */
public class LongestCommonPrefix {

    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */

    public static void main(String[] args){
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] arr = new String[]{"ABCD","ABEF","ACEF"};
        System.out.println(lcp.longestCommonPrefix(arr));
    }
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        TrieNode root = new TrieNode();
        for(String s : strs){
            root.insert(root, s);
        }
        return root.returnPrefix(root);
    }

    private class TrieNode{
        TrieNode[] child;
        char c;
        boolean isEnd;

        public TrieNode(){
            child = new TrieNode[26];
        }

        public void insert(TrieNode root, String word){
            System.out.println("Insert word "+word);
            if(root == null){
                root = new TrieNode();
            }
            for(char c : word.toCharArray()){
                if(root.child[c-'A'] == null){
                    root.child[c-'A'] = new TrieNode();
                }
                root.child[c-'A'].c = c;
                root = root.child[c-'A'];
            }
            root.isEnd = true;
        }

        public String returnPrefix(TrieNode root){
            StringBuilder sb = new StringBuilder();
            TrieNode crawl = root;
            while(crawl != null && !crawl.isEnd){
                int index = -1;
                int count = 0;
                for(int i = 0; i < 26; i++){
                    if(crawl.child[i] != null){
                        count++;
                        index = i;
                    }
                }
                if(count == 1) {
                    sb.append(crawl.child[index].c);
                    crawl = crawl.child[index];
                }
                else
                    return sb.toString();
            }
            return sb.toString();
        }


    }

}
