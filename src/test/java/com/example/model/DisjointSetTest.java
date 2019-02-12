package com.example.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DisjointSetTest {

    private DisjointSet dsj;

    @Before
    public void setUp() {
        dsj = new DisjointSet();
    }

    @Test
    public void unionTwoNodesWithTheSameRank() {
        // given
        dsj.make(1);
        dsj.make(2);
        dsj.union(1, 2);
        Map<Integer, Node> map = dsj.getMap();
        // when
        Node node1 = map.get(1);
        Node node2 = map.get(2);
        // then
        assertThat(node1.root).isNotNull();
        assertThat(node2.root).isNotNull();
        assertThat(node2.root).isEqualTo(node1);
        assertThat(node1.rank).isEqualTo(1);
        assertThat(node2.rank).isEqualTo(0);
    }

    @Test
    public void unionTwoNodesWithDifferentRank() {
        // given
        dsj.make(1);
        dsj.make(2);
        dsj.make(3);
        dsj.union(1, 2);
        Map<Integer, Node> map = dsj.getMap();
        // when
        Node node1 = map.get(1);
        Node node3 = map.get(3);
        dsj.union(1, 3);
        // then
        assertThat(node1.rank).isEqualTo(1);
        assertThat(node3.rank).isEqualTo(0);
        assertThat(node3.root).isEqualTo(node1);
    }

    @Test
    public void testPathCompression() {
        // given
        dsj.make(1);
        dsj.make(2);
        dsj.make(3);
        dsj.make(4);
        dsj.make(5);
        dsj.union(1, 2);
        dsj.union(3, 4);
        dsj.union(2, 3);
        Map<Integer, Node> map = dsj.getMap();
        // when
        dsj.union(4, 5);
        // then
        assertThat(map.get(3).root.key).isEqualTo(1);
        assertThat(map.get(4).root.key).isEqualTo(1);
        assertThat(map.get(5).root.key).isEqualTo(1);
    }
}