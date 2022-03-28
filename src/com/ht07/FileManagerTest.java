package com.ht07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileManagerTest {
    ArrayList<ArrayList<String>> data;
    ArrayList<ArrayList<String>> dataPrueba;
    @BeforeAll 
    void setUp(){
        ArrayList<String> temp = new ArrayList<>();    
        temp.add("house"); temp.add("casa"); temp.add("loger"); data.add(temp); temp.clear();
        temp.add("dog");  temp.add("perro"); temp.add("chien"); data.add(temp); temp.clear();
        temp.add("homework"); temp.add("tarea"); temp.add("devoirs"); data.add(temp); temp.clear();
        temp.add("woman"); temp.add("mujer"); temp.add("femme"); data.add(temp); temp.clear();
        temp.add("town"); temp.add("pueblo"); temp.add("ville"); data.add(temp); temp.clear();
        temp.add("yes"); temp.add("si"); temp.add("oui"); data.add(temp); temp.clear();
    }

    @Test
    void testCargarArchivoDiccionario() {
        dataPrueba = FileManager.cargarArchivoDiccionario("diccionario.txt");        
        assertEquals(data, dataPrueba);
    }

    @Test
    void testCargarArchivoEnunciado() {
        ArrayList<String> dat = new ArrayList<>();
        ArrayList<String> pru;        

        dat.add("The woman asked me to do my homework about my town.");
        dat.add("My town is beautiful.");
        pru = FileManager.cargarArchivoEnunciado("texto.txt");
        assertEquals(dat, pru);
    }
}
