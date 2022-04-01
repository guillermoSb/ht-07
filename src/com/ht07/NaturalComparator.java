package com.ht07;

import java.util.Comparator;

/**
 * Estructura de comparacion de dos objetos
 * @author Guillermo Santos
 * @param <E>
 */
public class NaturalComparator<E extends Comparable<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.compareTo(o2);
    }
}
