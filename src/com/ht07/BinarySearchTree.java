package com.ht07;

import java.util.Comparator;

public class BinarySearchTree<E extends Comparable<E>> {
    BinaryTree<E> root; // Root para este arbol binario
    protected final BinaryTree<E> EMPTY = new BinaryTree<E>();  // Crear un arbol empty
    protected int count;
    protected Comparator<E> ordering;

    /**
     * Construir un arbol binario vacio
     */
    public BinarySearchTree() {
        this.root = EMPTY;
        this.count = 0;
        this.ordering = new NaturalComparator<E>();
    }

    /**
     * Localizar el nodo en donde se debe de insertar el valor
     * @param root
     * @param value
     * @return
     */
    public BinaryTree<E> locate(BinaryTree<E> root, E value) {
        E rootValue = root.value();
        BinaryTree<E> node;
        // Verificar si el valor esta en el root
        if (rootValue == value) {return root;}
        // Comparar el valor del root
        if (ordering.compare(rootValue, value) < 0) {
            node = root.right();    // Asignar el hijo a la izquierda
        } else {
            node = root.left(); // Asignar el hijo a la derecha
        }

        if (node.isEmpty()) {
            return  root;   // Regresar la ubicación encontrada
        } else {
            return locate(node, value); // Recursividad
        }

    }

    /**
     * Agregar un valor al arbol
     * @param value
     */
    public void add(E value) {
        BinaryTree<E> newNode = new BinaryTree<>(value);
        if (root.isEmpty()) {
            root = newNode;  // Asignar el valor al root si este está vacío
        } else {
            BinaryTree<E> location = locate(root, value);   // Obtener la ubicación a insertar
            if (ordering.compare(location.value(), value) < 0) {
                location.setRight(newNode); // Insertar a la derecha
            } else {
                if (!location.left().isEmpty()) {
                    predecessor(location).setRight(newNode);    // Es un valor repetido
                } else {
                    location.setLeft(newNode);  // Insertar a la izquierda
                }
            }
        }
        count ++; // Incrementar el tamaño del arbol
    }

    /**
     * Saber si un valor está en la colección
     * @param value
     * @return
     */
    public boolean contains(E value) {
        if (root.isEmpty()) {return false;} // Si el root esta vacio regresar false de una vez;
        BinaryTree<E> result = locate(root, value); // Posible resultado
        return value.equals(result.value());    // Regresar si el resultado existe
    }


    /**
     * Obtener el valor previo a un nodo
     * @param root
     * @return
     */
    public BinaryTree<E> predecessor(BinaryTree<E> root) {
        if (root.isEmpty()) {return null;}  // No debe estar vacio
        if (root.isEmpty()) {return null;}  // Debe tener al menos un valor menor
        BinaryTree<E> result = root.left();
        while (!result.right().isEmpty()) {
            result = result.right();    // Asignar el valor de la derecha
        }
        return result;
    }

    /**
     * Obtener el numero de items en este arbol.
     * @return
     */
    public int getCount() {return  this.count;}



}
