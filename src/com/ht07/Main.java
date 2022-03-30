package com.ht07;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Guillermo Santos
 * @author Mariel Guamuche 
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<ArrayList<String>> dictionaryWords = new ArrayList<>(); // Arreglo temporal con las palabras leídas
        ArrayList<String> translatePhrase = new ArrayList<>();// frase a ser traducida
        BinaryTreeFactory treeBase = new BinaryTreeFactory(); // factory de creacion de diccionario
        Dictionary dict;
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean proceed = false;

        System.out.println("Bienvenido al diccionario inglés, español, francés");
        while(opcion!=7) {
            System.out.println("¿Qué deseas realizar?");
            System.out.println("1. Traducir del inglés al español \n2. Traducir del inglés al francés");
            System.out.println("3. Traducir del español al inglés \n4. Traducir del español al francés");
            System.out.println("5. Traducir del francés al español \n6. Traducir del francés al inglés\n7. Salir");
            opcion = isNumberC(scanner);

            if(opcion>=1 && opcion<=6) {
                System.out.println("Ingrese el nombre del archivo con las palabras del diccionario");
                String nombreArchivo = scanner.nextLine();
                dictionaryWords = FileManager.cargarArchivoDiccionario(nombreArchivo);
                if(!dictionaryWords.isEmpty()) {
                    System.out.println("Ingrese el nombre del archivo con la frase a traducir");
                    nombreArchivo = scanner.nextLine();
                    translatePhrase = FileManager.cargarArchivoEnunciado(nombreArchivo);
                    if(!translatePhrase.isEmpty())
                        proceed = true;
                }
            }

            if(proceed == true) {
                StringBuilder frase = new StringBuilder();
                String trad = "";
                for (String string : translatePhrase) {
                    frase.append(string);
                }
                switch (opcion) {
                    case 1: // inglés al español
                        dict = new Dictionary(treeBase.crearArbol("EN", dictionaryWords), "EN", "ES");                        
                        trad = dict.traducir(translatePhrase);
                    break;
                    case 2: // inglés al francés
                        dict = new Dictionary(treeBase.crearArbol("EN", dictionaryWords), "EN","FR");
                        trad = dict.traducir(translatePhrase);                       
                    break;
                    case 3: // español al inglés                        
                        dict = new Dictionary(treeBase.crearArbol("ES", dictionaryWords), "ES", "EN");
                        trad = dict.traducir(translatePhrase);
                    break; 
                    case 4: // español al francés                        
                        dict = new Dictionary(treeBase.crearArbol("ES", dictionaryWords), "ES", "FR");
                        trad = dict.traducir(translatePhrase);
                    break;
                    case 5: // francés al español                        
                        dict = new Dictionary(treeBase.crearArbol("FR", dictionaryWords), "FR", "ES");
                        trad = dict.traducir(translatePhrase);
                    break;
                    case 6: // francés al inglés                        
                        dict = new Dictionary(treeBase.crearArbol("FR", dictionaryWords), "FR", "EN");
                        trad = dict.traducir(translatePhrase);
                    break;
                    default: System.out.println("Opción no válida. Nos vemos pronto"); break;
                }
                System.out.println("Frase ingresada: \n\t"+frase);
                System.out.println("Frase traducida: \n\t"+trad);
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
