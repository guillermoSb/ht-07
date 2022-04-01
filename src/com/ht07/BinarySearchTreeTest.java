package com.ht07;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test del funcionamiento de la clase BinarySearchTree, es decir creación, búsqueda, insertar datos e iterar.
 * @author Guillermo Santos
 * @author Mariel Guamuche
 */
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

        ArrayList<String> mujer = new ArrayList<>();
        house.add("woman");
        house.add("mujer");
        house.add("femme");
        dict.add(mujer);

        ArrayList<String> pueblo = new ArrayList<>();
        house.add("town");
        house.add("pueblo");
        house.add("ville");
        dict.add(pueblo);

        BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> tree = factory.crearArbol("ES", dict);
        ComparableAssociation<String, HashMap<String, String>> casa = new ComparableAssociation<>("casa", null);
        assertTrue(tree.contains(casa));
        //assertEquals(tree.getCount(), 6);
    }

    @Test
    public void translate() {
        BinaryTreeFactory factory = new BinaryTreeFactory();
        ArrayList<ArrayList<String>> dict = FileManager.cargarArchivoDiccionario("diccionario.txt");

        BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> tree = factory.crearArbol("ES", dict);
        ComparableAssociation<String, HashMap<String, String>> casa = new ComparableAssociation<>("casa", null);
        assertEquals("loger", tree.locate(tree.root, casa).value().getValue().get("FR"));
        assertEquals("casa", tree.locate(tree.root, casa).value().getValue().get("ES"));
        assertEquals("house", tree.locate(tree.root, casa).value().getValue().get("EN"));

        ComparableAssociation<String, HashMap<String, String>> mujer = new ComparableAssociation<>("mujer", null);
        assertEquals("femme", tree.locate(tree.root, mujer).value().getValue().get("FR"));
        assertEquals("mujer", tree.locate(tree.root, mujer).value().getValue().get("ES"));
        assertEquals("woman", tree.locate(tree.root, mujer).value().getValue().get("EN"));

        ComparableAssociation<String, HashMap<String, String>> tarea = new ComparableAssociation<>("tarea", null);
        assertEquals("devoirs", tree.locate(tree.root, tarea).value().getValue().get("FR"));
        assertEquals("tarea", tree.locate(tree.root, tarea).value().getValue().get("ES"));
        assertEquals("homework", tree.locate(tree.root, tarea).value().getValue().get("EN"));
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
        ana.add("woman");
        ana.add("mujer");
        ana.add("femme");



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

    public void binaryTreeFactory2() {
        BinaryTreeFactory factory = new BinaryTreeFactory();
        ArrayList<ArrayList<String>> dict = FileManager.cargarArchivoDiccionario("diccionario.txt");

        BinarySearchTree<ComparableAssociation<String, HashMap<String, String>>> tree = factory.crearArbol("ES", dict);
        ComparableAssociation<String, HashMap<String, String>> data = new ComparableAssociation<>("tarea", null);
        assertTrue(tree.contains(data));
        //assertEquals("tarea", tree.locate(tree.root, data).value().getValue().get("ES"));

        assertEquals(tree.getCount(), 6);
    }
}










