package com.ht07;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Dictionary {    
    private String idiomaOrigen;
    private String idiomaTrad;
    private BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> diccionario; /* arbol donde se almacena el diccionario */
    private ComparableAssociation<String, HashMap<String, String>> palabra;

    public Dictionary(BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> dict, String idiomaOrigen, String idiomaTrad) {
        this.diccionario = dict;
        this.idiomaOrigen = idiomaOrigen;
        this.idiomaTrad = idiomaTrad;
        System.out.println("Idioma de origen: " + this.idiomaOrigen);
        System.out.println("Diccionario impreso en in-order:");
        System.out.println(this.diccionario);
    }

    public BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> getDictionary() {
        return this.diccionario;
    }

    public String getIdiomaOrigen() {
        return idiomaOrigen;
    }

    public String traducir(ArrayList<String> enunciado){
        StringBuilder traduccion = new StringBuilder();
        
        for (String string : enunciado) {
            if(string.isBlank() || string.isEmpty() || string.equals(".") || string.equals(",") || string.equals(";") || string.equals(":")) {
                traduccion.append(string);
            } else {
               if(existe(string.toLowerCase())==true){
                   this.palabra = new ComparableAssociation<>(string.toLowerCase(), null);
                   traduccion.append(this.diccionario.locate(this.diccionario.root, palabra).value().getValue().get(this.idiomaTrad));
               } else {
                   traduccion.append("*"+string+"*");
               }
            }
        }
        return traduccion.toString();
    }

    private boolean existe(String palabra) {
        this.palabra = new ComparableAssociation<>(palabra, null);        
        return diccionario.contains(this.palabra);
    }
}
