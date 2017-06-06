package Palantir;

/**
 * Created by swapnil on 3/15/2017.
 */
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
 * Complete the function below.
 */
    static private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    static int findMax(int n, String tree) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(tree.split(" ")));
        TreeNode root = deserialize(nodes, n);
        return findMax(root, new HashMap<TreeNode, Integer>());
    }

    static private int findMax(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int retVal = 0;

        if(root.left != null){
            retVal += findMax(root.left.left, map) + findMax(root.left.right, map);
        }

        if(root.right != null){
            retVal += findMax(root.right.left, map) + findMax(root.right.right, map);
        }

        retVal = Math.max(retVal + root.val, findMax(root.left, map) + findMax(root.right, map));
        map.put(root, retVal);
        return retVal;
    }

    @Nullable
    static private TreeNode deserialize(Deque<String> nodes, int n){
        if(nodes.isEmpty()) return null;
        String s = nodes.remove();
        if(s.equals("#") || n == 0) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = deserialize(nodes, n - 1);
        root.right = deserialize(nodes, n - 1);
        return root;
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int res;
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        String _tree;
        try {
            _tree = in.nextLine();
        } catch (Exception e) {
            _tree = null;
        }

        res = findMax(_n, _tree);
        System.out.println(res);
    }
}