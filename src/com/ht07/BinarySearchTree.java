package com.ht07;

/**
 * Implementación de un arbol binario de búsqueda.
 * @author Mariel Guamuche
 * @author Guillermo Santos
 * @param <E>
 */
public class BinarySearchTree<E> {
    protected E val;    // Value to store
    protected BinarySearchTree<E> parent; // Parent
    protected BinarySearchTree<E> left, right;    // Left and right nodes
    private Iterator<E> iterator;

    public BinarySearchTree() {
        val = null;
        parent = null;  // An empty tree has no value
        left = right = this;    // Its left and right items are itself
        iterator = new BTOrderIterator<>(this);

    }

    public BinarySearchTree(E value) {
        val = value;
        right = left = new BinarySearchTree<E>(); // Attach two empty subtrees to the left and right
        setLeft(left);
        setRight(right);
        iterator = new BTOrderIterator<>(this);
    }

    public BinarySearchTree(E value, BinarySearchTree<E> left, BinarySearchTree<E> right) {
        val = value;
        if (left == null) {left = new BinarySearchTree<>();}
        setLeft(left);
        if (right == null) {right = new BinarySearchTree<>();}
        setRight(right);
        iterator = new BTOrderIterator<>(this);
    }

    public Iterator iterator() {
        return this.iterator;
    }

    public BinarySearchTree<E> left() {
        return left;
    }

    public BinarySearchTree<E> right() {
        return right;
    }

    public BinarySearchTree<E> parent() {
        return parent;
    }

    public void setLeft(BinarySearchTree<E> newLeft) {
        if (isEmpty()) return;  // Do not do anything if the node is empty
        if (left != null && left.parent() == this) left.setParent(null);    // Set the actual node left parent to null if there is already a value
        left = newLeft;
        left.setParent(this);
    }

    public void setRight(BinarySearchTree<E> newRight) {
        if (isEmpty()) return;  // Do not do anything if the node is empty
        if (right != null && right.parent() == this) right.setParent(null);    // Set the actual node left parent to null if there is already a value
        right = newRight;
        right.setParent(this);
    }

    protected void setParent(BinarySearchTree<E> newParent) {
        if (!isEmpty()) {
            this.parent = newParent;
        }
    }



    public E value() {
        return val;
    }

    public void setValue(E value) {
        val = value;
    }

    public boolean isEmpty() {
        return parent == null && (val == null && right == this && left == this);
    }


}
