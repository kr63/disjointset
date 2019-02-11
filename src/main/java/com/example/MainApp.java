package com.example;

import com.example.model.DisjointSet;

public class MainApp {

    public static void main(String[] args) {

        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7};
        new MainApp().solve(values);
    }

    private void solve(int[] values) {
        DisjointSet disjointSet = new DisjointSet();
        for (Integer value : values) {
            disjointSet.makeSet(value);
        }
    }
}
