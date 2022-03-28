package com.ht07;

/**
 * Estructura de un iterador.
 * @author Mariel Guamuche
 * @author Guillermo Santos
 * @param <E>
 */
public interface Iterator<E> {
    public void reset();
    public boolean hasNext();
    public E get();
    public E next();
}
