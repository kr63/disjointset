package com.example.model;

public class DisjointSet {

    public void makeSet(int key) {
        Node node = new Node();
        node.key = key;
        node.root = node;
        node.rank = 0;
    }
}
