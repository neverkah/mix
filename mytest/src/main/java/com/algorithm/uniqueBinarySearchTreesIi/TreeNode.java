package com.algorithm.uniqueBinarySearchTreesIi;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    Queue<int[]> treeList;

    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();
        int[] x1 = new int[]{1, 1, 1};
        int[] x2 = new int[]{1, 1, 1};
        List list1 = Arrays.asList(x1);
        List list2 = Arrays.asList(x1);
        set.add(list1);
        set.add(list2);
//        System.out.println(set.size());
        Solution solution = new Solution();
        solution.generateTree(4);
        System.out.println(solution.treeList.size());
    }

    public List<TreeNode> generateTrees(int n) {
        return null;
    }

    public void generateTree(int n) {
        treeList = new LinkedList<>();
        int[] firstTree = new int[255];
        firstTree[0] = 1;
        treeList.add(firstTree);
        int range = 2;
        for (int i = 2; i <= n; i++) {
            int treeListSize = treeList.size();
            while (true) {
                int[] tree = treeList.poll();
                for (int index = 0; index < range - 1; index++) {
                    if (tree[index] == 1 && tree[2 * index + 1] == 0) {
                        int[] temp = new int[255];
                        System.arraycopy(tree, 0, temp, 0, range - 1);
                        temp[2 * index + 1] = 1;
                        treeList.add(temp);
                    }
                    if (tree[index] == 1 && tree[2 * index + 2] == 0) {
                        int[] temp = new int[255];
                        System.arraycopy(tree, 0, temp, 0, range - 1);
                        temp[2 * index + 2] = 1;
                        treeList.add(temp);
                    }
                }
                treeListSize--;
                if (treeListSize == 0) {
                    break;
                }
            }
            range *= 2;
        }

    }
}