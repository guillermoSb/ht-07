package com.ht07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Manejo de archivo de texto
 * @author Mariel Guamuche
 */
public class FileManager {
    private FileManager(){}

    /**
     * Realiza el arreglo de arreglo de las palabras leídas
     * @param nombreArchivo Archivo donde se encuentran las palabras del diccionario
     * @return arreglo de arreglo stirng
     */
    public static ArrayList<ArrayList<String>> cargarArchivoDiccionario(String nombreArchivo) {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        File file;          // archivo de texto 
        FileReader fr;      // objeto que asegura la lectura del archivo
        BufferedReader bf;  // objeto similar al cursor 

        // se coloca try-catch para que trate de realizar la lectura, si se levanta una excepción será tomada con el catch.
        try {
            file = new File(nombreArchivo);        // se especifica el archivo
            fr = new FileReader(file);      // se asigna a qué archivo se leerá
            bf = new BufferedReader(fr);    // se agrega un cursor de lectura
            String bfRead;                  // linea utilizada para el condicional
            ArrayList<String> temp = new ArrayList<>();
            int i=0;
            while ((bfRead = bf.readLine()) != null) {
                String[] dato = bfRead.split(",");
                temp.add(dato[0].strip().toLowerCase()); temp.add(dato[1].strip().toLowerCase()); temp.add(dato[2].strip().toLowerCase());
                data.add((ArrayList<String>) temp.clone());
                temp.clear(); i++;
            }
            bf.close(); // se cierra el cursor
            fr.close(); // se cierra el archivo
        } catch(Exception e){
            System.out.println("No se ha encontrado el texto " + nombreArchivo); // excepción 
        } 

        return data; // retorno de la lista info con los elementos leídos.
    }

    /**
     * Acomoda los datos en un arreglo string
     * @param nombreArchivo Archivo con enunciado
     * @return ArrayList
     */
    public static ArrayList<String> cargarArchivoEnunciado(String nombreArchivo) {
        ArrayList<String> data = new ArrayList<>();
        File file;          // archivo de texto 
        FileReader fr;      // objeto que asegura la lectura del archivo
        BufferedReader bf;  // objeto similar al cursor 

        // se coloca try-catch para que trate de realizar la lectura, si se levanta una excepción será tomada con el catch.
        try {
            file = new File(nombreArchivo);        // se especifica el archivo
            fr = new FileReader(file);      // se asigna a qué archivo se leerá
            bf = new BufferedReader(fr);    // se agrega un cursor de lectura
            String bfRead;                  // linea utilizada para el condicional
            while ((bfRead = bf.readLine()) != null) {
                StringBuilder reader = new StringBuilder();
                String comillaSimple = "'";
                for (int i = 0; i<bfRead.length(); i++) {
                    if(Character.isLetter(bfRead.charAt(i))||bfRead.charAt(i)==comillaSimple.charAt(0)){
                        reader.append(bfRead.charAt(i)); // concatenacion para crear palabra
                    } else {
                        data.add(reader.toString()); // al ser otro caracter, se agrega la palabra reader
                        data.add(bfRead.charAt(i)+""); // se agrega el caracter no alfabetico
                        reader.setLength(0); // se "vacia" el StringBuilder
                    }
                }
            }
            bf.close(); // se cierra el cursor
            fr.close(); // se cierra el archivo
        } catch(Exception e){
            System.out.println("No se ha encontrado el texto " + nombreArchivo); // excepción 
        } 

        return data; // retorno de la lista info con los elementos leídos.
    }   
}
