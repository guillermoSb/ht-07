package com.ht07;
import java.util.HashMap;

public class Dictionary {
    private BinaryTree<HashMap<String, HashMap<String, String>>> diccionario;
    private String idiomaOrigen;

    public Dictionary(BinaryTree<HashMap<String, HashMap<String, String>>> dict, String idiomaOrigen) {
        this.diccionario = dict;
        this.idiomaOrigen = idiomaOrigen;
    }

    /*public getDictionary() {
        return this.diccionario;
    }*/

    public String getIdiomaOrigen() {
        return idiomaOrigen;
    }

    public String traducir(String enunciado){
        return "";
    }
}
