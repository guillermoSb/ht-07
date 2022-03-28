package com.ht07;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Guillermo Santos
 * @author Mariel Guamuche 
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> dictionaryWords; // Arreglo temporal con las palabras leídas
        ArrayList<String> translatePhrase;// frase a ser traducida 
        Scanner scanner = new Scanner(System.in); 
        int opcion = 0;
        boolean proceed = false;

        System.out.println("Bienvenido al diccionario inglés, español, francés");
        while(opcion!=3) {
            System.out.println("¿Qué deseas realizar?");
            System.out.println("1. Traducir del inglés al español \n2. Traducir del inglés al francés\n3. Salir");
            opcion = isNumberC(scanner);
            if(opcion==1||opcion==2) {
                System.out.println("Ingrese el nombre del archivo con las palabras del diccionario");
                String nombreArchivo = scanner.nextLine();
                dictionaryWords = FileManager.cargarArchivoDiccionario(nombreArchivo);
                System.out.println("Ingrese el nombre del archivo con la frase a traducir");
                translatePhrase = FileManager.cargarArchivoEnunciado(nombreArchivo);
                proceed = true;
            }           
            
            if(proceed == true) {
                if(opcion==1) {
                    // create tree map in english and spanish 
    
                } else if(opcion==2){
                    // create tree map in english and french
    
                }
            } else System.err.println("Su archivo no fue encontrado. Asegurese de ingresar el nombre del archivo y extension");            
        }
        scanner.close();
    }

    public static int isNumberC(Scanner scanner) {
        boolean correct=false;
        int num = 0;
        while(correct==false) {
            try{
                num = Integer.parseInt(scanner.nextLine());
                correct=true;
            } catch(NumberFormatException e) {
                System.out.println("Ingrese una opción valida");
            }
        }
        return num;
    }
}