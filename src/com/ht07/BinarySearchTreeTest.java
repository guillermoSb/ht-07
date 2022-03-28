package com.ht07;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    @Test
    public void binaryTreeFactory() {
        BinaryTreeFactory factory = new BinaryTreeFactory();
        ArrayList<ArrayList<String>> dict = new ArrayList<>();
        ArrayList<String> house = new ArrayList<>();
        house.add("house");
        house.add("casa");
        house.add("loger");
        dict.add(house);
        BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> tree = factory.crearArbol("ES", dict);
        ComparableAssociation<String, HashMap<String, String>> casa = new ComparableAssociation<>("casa", null);
        assertTrue(tree.contains(casa));
        assertEquals(tree.getCount(), 1);
    }

    @Test
    public void translate() {
        BinaryTreeFactory factory = new BinaryTreeFactory();
        ArrayList<ArrayList<String>> dict = new ArrayList<>();
        ArrayList<String> house = new ArrayList<>();
        house.add("house");
        house.add("casa");
        house.add("loger");
        dict.add(house);
        BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> tree = factory.crearArbol("ES", dict);
        ComparableAssociation<String, HashMap<String, String>> casa = new ComparableAssociation<>("casa", null);
        assertEquals("loger", tree.locate(tree.root, casa).value().getValue().get("FR"));
        assertEquals("casa", tree.locate(tree.root, casa).value().getValue().get("ES"));
    }
}
