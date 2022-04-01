package com.ht07;

/**
 * Estructura de almacenamiento jerárquico de un árbol binario básico.
 * @author Guillermo Santos
 * @param <E>
 */
public class BinaryTree<E> {
    protected E val;    // Valor a guardar
    protected BinaryTree<E> parent; // Padre de este nodo
    protected BinaryTree<E> left, right;    // Valores de la izquierda y derecha
    protected Iterator iterator;

    /**
     * Crear un arbol vacío
     */
    public BinaryTree() {
        val = null;
        parent = null;
        left = right = this;
        iterator = new BTOrderIterator(this);
    }

    /**
     * Crear un arbol con un valor
     * @param value
     */
    public BinaryTree(E value) {
        val = value;
        right = left = new BinaryTree<E>();
        setLeft(left);
        setRight(right);
        iterator = new BTOrderIterator(this);
    }

    /**
     * Crear un arbol especificando nodos
     * @param value
     * @param left
     * @param right
     */
    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right) {
        val = value;
        if (left == null) {left = new BinaryTree<>();}
        setLeft(left);
        if (right == null) {right = new BinaryTree<>();}
        setRight(right);
        iterator = new BTOrderIterator(this);
    }

    /**
     * Obtener el valor izquierdo
     * @return
     */
    public BinaryTree<E> left() {
        return left;
    }

    /**
     * Obtener el valor derecho
     * @return
     */
    public BinaryTree<E> right() {
        return right;
    }

    /**
     * Obtener el padre de este nodo.
     * @return Nodo padre
     */
    public BinaryTree<E> parent() {
        return parent;
    }

    /**
     * Asignar un valor al nodo izquierdo
     * @param newLeft
     */
    public void setLeft(BinaryTree<E> newLeft) {
        if (isEmpty()) return;  // Do not do anything if the node is empty
        if (left != null && left.parent() == this) left.setParent(null);    // Set the actual node left parent to null if there is already a value
        left = newLeft;
        left.setParent(this);
    }

    /**
     * Asignar un valor al nodo derecho
     * @param newRight
     */
    public void setRight(BinaryTree<E> newRight) {
        if (isEmpty()) return;  // Do not do anything if the node is empty
        if (right != null && right.parent() == this) right.setParent(null);    // Set the actual node left parent to null if there is already a value
        right = newRight;
        right.setParent(this);
    }

    /**
     * Asignar un valor al padre
     * @param newParent
     */
    protected void setParent(BinaryTree<E> newParent) {
        if (!isEmpty()) {
            this.parent = newParent;
        }
    }

    /**
     * Obtener valor de este nodo
     * @return Valor
     */
    public E value() {
        return val;
    }

    /**
     * Asignar un valor al nodo
     * @param value
     */
    public void setValue(E value) {
        val = value;
    }

    /**
     * Indicación si el arbol está vacío
     * @return
     */
    public boolean isEmpty() {
        return parent == null && (val == null && right == this && left == this);
    }

    /**
     * Retorna el iterador del árbol ya ordenado.
     * @return Iterator
     */
    public Iterator iterator() {
        return new BTOrderIterator(this);
    }


}
