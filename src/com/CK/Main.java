package com.CK;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Node four = new Node(4, null, null, null);
        Node five = new Node(5, null, null, null);
        Node six = new Node(6, null, null, null);
        Node seven = new Node(7, null, null, null);
        Node two = new Node(2, four, five, null);
        Node three = new Node(3, six, seven, null);
        Node one = new Node(1, two, three, null);
        Solution solution = new Solution();
        solution.connect(one);
        System.out.println("");
    }
}

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> bfsList = new LinkedList<>();
        bfsList.offer(root);
        bfsList.offer(null);
        bfs(root, bfsList);
        return root;
    }

    private void bfs(Node root, Queue<Node> bfsList) {
        while (bfsList.size() > 1) {
            Node node = bfsList.poll();
            node.next = bfsList.peek();
            if (node == null) {
                bfsList.offer(null);
            } else {
                if (node.left != null)
                    bfsList.offer(node.left);
                if (node.right != null)
                    bfsList.offer(node.right);
            }
            bfs(root, bfsList);
        }
    }
}
