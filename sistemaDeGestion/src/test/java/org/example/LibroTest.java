package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LibroTest {

    @Test
    void testCrearLibroValido() {
        Libro libro = Libro.builder()
                .isbn("978-3-16-148410-0")
                .titulo("Clean Code")
                .autor("Robert C. Martin")
                .estado(Estado.DISPONIBLE)
                .build();
        assertEquals("978-3-16-148410-0", libro.getIsbn());
        assertEquals("Clean Code", libro.getTitulo());
        assertEquals("Robert C. Martin", libro.getAutor());
        assertEquals(Estado.DISPONIBLE, libro.getEstado());
    }

    @Test
    void testCambioEstadoLibro() {
        Libro libro = Libro.builder()
                .isbn("978-3-16-148410-0")
                .titulo("Clean Code")
                .autor("Robert C. Martin")
                .estado(Estado.DISPONIBLE)
                .build();
        libro.setEstado(Estado.PRESTADO);
        assertEquals(Estado.PRESTADO, libro.getEstado());
    }
}
