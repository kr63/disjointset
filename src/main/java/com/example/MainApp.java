package com.example;

import com.example.model.DisjointSet;
import com.example.model.Node;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainApp {

    public static void main(String[] args) {

        DisjointSet disjointSet = new DisjointSet();
        int[] keys = new int[]{1, 2, 3, 4, 5, 6, 7};
        for (Integer key : keys) {
            disjointSet.make(key);
        }

        disjointSet.union(1, 2);
        disjointSet.union(2, 3);
        disjointSet.union(4, 5);
        disjointSet.union(6, 7);
        disjointSet.union(5, 6);
        disjointSet.union(3, 7);

        Set<Node> roots = new HashSet<>();
        Map<Integer, Node> map = disjointSet.getMap();
        for (Integer key : map.keySet()) {
            Node node = map.get(key);
            Node root = disjointSet.find(node);
            System.out.println("Node: " + node.key + "; Root: " + root.key +
                    "; Rank: " + node.rank + "\n");
            roots.add(root);
        }

        System.out.println(roots.size());
    }
}
