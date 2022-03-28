package com.ht07;

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTreeFactory {

    /**
     * Crear un arbol
     * @return
     */
    public BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> crearArbol(String idioma, ArrayList<ArrayList<String>> palabras) {
        int wordIndex = 0;
        if(idioma.equals("ES")) {
            wordIndex = 1;
        } else if(idioma.equals("FR")) {
            wordIndex = 2;
        } else if(idioma.equals("EN")) {
            wordIndex = 0;
        } else {
            return null;
        }
        // Insertar las palabras en el arbol binario
        BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> tree = new BinarySearchTree<>(); // Arbol a regresar
        for (int i = 0; i < palabras.size(); i++) {
            ArrayList<String> palabra = palabras.get(i);
            HashMap<String, String> wordHashMap = new HashMap<>();
            wordHashMap.put("EN", palabra.get(0));
            wordHashMap.put("ES", palabra.get(1));
            wordHashMap.put("FR", palabra.get(2));
            ComparableAssociation<String, HashMap<String, String>> entryPalabra = new ComparableAssociation<>(palabra.get(wordIndex), wordHashMap);
            tree.add(entryPalabra);
        }
        return tree;
    }
}
