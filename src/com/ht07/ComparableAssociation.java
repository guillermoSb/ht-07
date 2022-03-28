package com.ht07;

public class ComparableAssociation<K extends Comparable<K>, V> extends Association<K,V>{

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

    public String toString() {
        StringBuffer s = new StringBuffer();    // Buffer para ir creando string
        s.append("<ComparableAssociation: " + getKey() + "=" + getValue() + ">");   // Agregar al buffer
        return s.toString();    // Regresar el valor de la string
    }
}
