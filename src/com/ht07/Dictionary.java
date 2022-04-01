package com.ht07;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Diccionario
 * @author Guillermo Santos
 * @author Mariel Guamuche
 */
public class Dictionary {    
    private String idiomaOrigen; // idioma base del diccionario
    private String idiomaTrad;   // idioma asociado para la traducción
    private BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> diccionario; /* arbol donde se almacena el diccionario */
    private ComparableAssociation<String, HashMap<String, String>> palabra; // asociación comparable para encontrar la asociación en el árbol del diccionario

    /**
     * Constructor
     * Crea el objeto de tipo diccionario así como indica el tipo de idioma junto a los valores asociados
     * @param dict diccionario tipo BinarySearchTree
     * @param idiomaOrigen String idioma base
     * @param idiomaTrad String idioma a traducir
     */
    public Dictionary(BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> dict, String idiomaOrigen, String idiomaTrad) {
        this.diccionario = dict;
        this.idiomaOrigen = idiomaOrigen;
        this.idiomaTrad = idiomaTrad;
        System.out.println("Idioma de origen: " + this.idiomaOrigen);
        System.out.println("Diccionario impreso en in-order:");
        System.out.println(this.diccionario);
    }

    /**
     * Retorno del diccionario implementado
     * @return
     */
    public BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> getDictionary() {
        return this.diccionario;
    }

    /***
     * Retorna el valor del idioma de origen del diccionario
     * @return
     */
    public String getIdiomaOrigen() {
        return this.idiomaOrigen;
    }

    /**
     * Traduce las palabras de un texto en base al diccionario, en caso de no encontrar la palabra se coloca entre asteriscos
     * @param enunciado Enunciado que se desea traducir
     * @return String con oración traducida
     */
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

    /**
     * Válida que la palabra esté definida en el diccionario
     * @param palabra String de palabra a buscar en diccionario
     * @return true-> la palabra esta definida, false -> la palabra no esta definida
     */
    private boolean existe(String palabra) {
        this.palabra = new ComparableAssociation<>(palabra, null);        
        return diccionario.contains(this.palabra);
    }
}
