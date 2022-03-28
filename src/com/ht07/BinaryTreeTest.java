package com.ht07;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BinaryTreeTest {


    @Test
    public void constructor() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertTrue(tree != null);   // El arbol nunca debe ser nulo
    }

    @Test
    public void value(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setValue(2);
        assertEquals(tree.value(), 2);  // El valor debe ser 2
    }

    @Test
    public void setValue() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertEquals(null, tree.value());
        tree.setValue(2);
        assertEquals(tree.value(), 2);
    }

    @Test
    public void left() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setValue(2);
        tree.setLeft(new BinaryTree<>(5));
        assertEquals(5, tree.left.value());
    }
    @Test
    public void right() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setValue(2);
        tree.setRight(new BinaryTree<>(5));
        assertEquals(5, tree.right.value());
    }


    @Test
    public void isEmpty() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertEquals(true, tree.isEmpty());
        tree.setValue(2);
        assertEquals(false, tree.isEmpty());
    }
}
