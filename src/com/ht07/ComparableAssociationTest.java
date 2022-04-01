package com.ht07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas de la clase ComparableAssociation.
 * @author Guillermo Santos
 */
public class ComparableAssociationTest {

    @Test
    public void testStringComparison() {
        ComparableAssociation<String, String> a = new ComparableAssociation<>("a", "a");
        ComparableAssociation<String, String> b = new ComparableAssociation<>("b", "b");
        assertEquals(a.compareTo(b), -1);
        assertEquals(a.compareTo(a), 0);
        assertEquals(b.compareTo(a), 1);
    }
}
