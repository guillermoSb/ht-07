package com.ht07;


import java.util.Stack;
/**
 * Implementación de un iterador.
 * @author Mariel Guamuche
 * @author Guillermo Santos
 * @param <E>
 */
public class BTOrderIterator<E> implements Iterator<E> {
        protected BinarySearchTree<E> root;   // root of the tree
        protected Stack<BinarySearchTree<E>> todo; // Stack of unvisited nodes
        public BTOrderIterator(BinarySearchTree<E> root) {
            todo = new Stack<>();   // Create the stack
            this.root = root;   // Assign the root
            reset();    // Reset the iterator
        }

        @Override
        public void reset() {
            // Clear the todo
            todo.clear();
            // Add all the subtrees from the left leafs
            BinarySearchTree<E> current = root;
            while (!current.isEmpty()) {
                todo.push(current);
                current = current.left();
            }
        }

        @Override
        public boolean hasNext() {
            return !todo.isEmpty();
        }

        @Override
        public E get() {
            return todo.get(todo.size() - 1).value();
        }

        @Override
        public E next() {
            BinarySearchTree<E> old = todo.pop();
            E result = old.value(); // Value to be popped
            // There are no left descendants left on this node
            // Start adding the right tree to the stack if it is not empty
            if (!old.right().isEmpty()) {
                BinarySearchTree<E> current = old.right();
                do {
                    todo.push(current); // Push the current value
                    current = current.left();   // Set the value as the left subtree
                } while (!current.isEmpty());
            }
            return result;
        }
    }

