package com.ht07;

/**
 * Clase para comparación entre asociaciones.
 * Utilizada principalmente para la asignación de posiciones para el BinarySearchTree
 * @author Guillermo Santos
 * @param <K>
 * @param <V>
 */
public class ComparableAssociation<K extends Comparable<K>, V>  extends Association<K,V> implements Comparable<ComparableAssociation<K,V>>{

    /**
     * Crear una asociacion comparable.
     *
     * @param key
     * @param value
     */
    public ComparableAssociation(K key, V value) {
        super(key, value);
    }

    /**
     * Compare this association to a value
     * @param that
     * @return
     */
    public int compareTo(ComparableAssociation<K,V> that) {
        return this.getKey().compareTo(that.getKey());
    }

    /**
     * Equals
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        ComparableAssociation<K,V> that = (ComparableAssociation<K, V>) obj;
        return that.getKey().equals(this.getKey());
    }

    public String toString() {
        StringBuffer s = new StringBuffer();    // Buffer para ir creando string
        s.append(getKey() + "=" + getValue());   // Agregar al buffer
        return s.toString();    // Regresar el valor de la string
    }


}
