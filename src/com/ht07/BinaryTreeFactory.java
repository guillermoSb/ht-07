package com.ht07;

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTreeFactory<E> {

    /**
     * Crear un arbol
     * @return
     */
    //    public BinaryTree<E> crearArbol(String idioma, ArrayList<ArrayList<String>> palabras) {
//        for (String palabra:
//             palabras) {
//
//        }
//    }

    public BinaryTree<E> crearArbol(String idioma, ArrayList<ArrayList<String>> palabras){        
        switch(idioma){
            case "Ing":
                
            break;
            case "Esp":
            break;
            case "Fre":
            break;
            default:
            break;
        }
        return new BinaryTree<>();
    }

    private HashMap<String,String> putValuesMap(ArrayList<ArrayList<String>> palabras){
        HashMap<String, String> data = new HashMap<>();
        for (ArrayList<String> element : palabras) {
            data.put("english", element.get(0));
            data.put("spanish", element.get(1));
            data.put("french", element.get(2));
        }
        return data;
    }
}
