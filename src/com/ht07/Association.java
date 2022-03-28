package com.ht07;

public class Association<K, V> {
    protected K key;    // Llave para la asociacion
    protected V value;  // Valor para la asociacion

    /**
     * Crear una asociacion
     * @param key
     * @param value
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Obtener el valor de la asociacion.
     * @return
     */
    public V getValue() {
        return value;
    }

    /**
     * Obtener la llave de la asociacion.
     * @return
     */
    public K getKey() {
        return key;
    }

    /**
     * Asignar un valor a la asociacion.
     * @param value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Asignar un valor a la llave de la asociacion.
     * @param key
     */
    public void setKey(K key) {
        this.key = key;
    }
}
