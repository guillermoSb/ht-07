package com.ht07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileManager {
    private FileManager(){}

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
            while ((bfRead = bf.readLine()) != null) {
                String[] dato = bfRead.split(",");
                temp.add(dato[0].strip().toLowerCase()); temp.add(dato[1].strip().toLowerCase()); temp.add(dato[2].strip().toLowerCase());
                data.add(temp); 
                temp.clear();
            }
            bf.close(); // se cierra el cursor
            fr.close(); // se cierra el archivo
        } catch(Exception e){
            System.out.println("No se ha encontrado el texto " + nombreArchivo); // excepción 
        } 

        return data; // retorno de la lista info con los elementos leídos.
    }    

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
                data.add(bfRead); // separarlo por palabras?
            }
            bf.close(); // se cierra el cursor
            fr.close(); // se cierra el archivo
        } catch(Exception e){
            System.out.println("No se ha encontrado el texto " + nombreArchivo); // excepción 
        } 

        return data; // retorno de la lista info con los elementos leídos.
    }   
}
