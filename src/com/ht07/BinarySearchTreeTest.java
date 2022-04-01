package com.ht07;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    @Test
    public void binaryTreeFactory() {
        BinaryTreeFactory factory = new BinaryTreeFactory();
        ArrayList<ArrayList<String>> dict = new ArrayList<>();
        ArrayList<String> house = new ArrayList<>();
        house.add("house");
        house.add("casa");
        house.add("loger");
        dict.add(house);
        BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> tree = factory.crearArbol("ES", dict);
        ComparableAssociation<String, HashMap<String, String>> casa = new ComparableAssociation<>("casa", null);
        assertTrue(tree.contains(casa));
        assertEquals(tree.getCount(), 1);
    }

    @Test
    public void translate() {
        BinaryTreeFactory factory = new BinaryTreeFactory();
        ArrayList<ArrayList<String>> dict = new ArrayList<>();
        ArrayList<String> house = new ArrayList<>();
        house.add("house");
        house.add("casa");
        house.add("loger");
        dict.add(house);
        BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> tree = factory.crearArbol("ES", dict);
        ComparableAssociation<String, HashMap<String, String>> casa = new ComparableAssociation<>("casa", null);
        assertEquals("loger", tree.locate(tree.root, casa).value().getValue().get("FR"));
        assertEquals("casa", tree.locate(tree.root, casa).value().getValue().get("ES"));
    }

    @Test
    public void iterator() {
        BinaryTreeFactory factory = new BinaryTreeFactory();
        ArrayList<ArrayList<String>> dict = new ArrayList<>();
        ArrayList<String> house = new ArrayList<>();
        house.add("house");
        house.add("casa");
        house.add("loger");
        ArrayList<String> dog = new ArrayList<>();
        dog.add("dog");
        dog.add("perro");
        dog.add("chien");
        ArrayList<String> arbol = new ArrayList<>();
        arbol.add("tree");
        arbol.add("arbol");
        arbol.add("arbre");
        ArrayList<String> ana = new ArrayList<>();
        ana.add("ana");
        ana.add("ana");
        ana.add("ana");



        dict.add(house);
        dict.add(ana);
        dict.add(arbol);
        dict.add(dog);
        BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> tree = factory.crearArbol("ES", dict);

    //  Probar que el iterator sirve
        Iterator iterator = tree.root.iterator();
        while (iterator.hasNext()) {
           System.out.println(iterator.next());
      }
    }

    @Test
    public void testFileTranslate() {
        ArrayList<ArrayList<String>> dictionaryWords = new ArrayList<>();
        dictionaryWords = FileManager.cargarArchivoDiccionario("diccionario.txt");
        ArrayList<String> translatePhrase = FileManager.cargarArchivoEnunciado("textoES.txt");
        assertTrue(!translatePhrase.isEmpty());
        BinaryTreeFactory treeBase = new BinaryTreeFactory();
        BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> tree = treeBase.crearArbol("ES", dictionaryWords);
        ComparableAssociation<String, HashMap<String, String>> tarea = new ComparableAssociation<>("tarea", null);
        Iterator iterator = tree.root.iterator();
        assertTrue(tree.contains(tarea));;

    }

}










