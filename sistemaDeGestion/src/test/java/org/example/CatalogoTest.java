package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CatalogoTest {

    private Catalogo catalogo;
    private Libro libro1;
    private Libro libro2;

    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        libro1 = Libro.builder().isbn("978-3-16-148410-0").titulo("Clean Code").autor("Robert C. Martin").estado(Estado.DISPONIBLE).build();
        libro2 = Libro.builder().isbn("978-0-13-235088-4").titulo("Clean Architecture").autor("Robert C. Martin").estado(Estado.DISPONIBLE).build();
        catalogo.agregarLibro(libro1);
        catalogo.agregarLibro(libro2);
    }

    @Test
    void testAgregarLibro() {
        assertEquals(2, catalogo.obtenerLibrosDisponibles().size());
    }

    @Test
    void testBuscarPorIsbnExitoso() {
        Libro libro = catalogo.buscarPorIsbn("978-3-16-148410-0");
        assertNotNull(libro);
        assertEquals("Clean Code", libro.getTitulo());
    }

    @Test
    void testBuscarPorIsbnFallido() {
        Libro libro = catalogo.buscarPorIsbn("000-0-00-000000-0");
        assertNull(libro);
    }

    @Test
    void testObtenerLibrosDisponibles() {
        libro1.setEstado(Estado.PRESTADO);
        List<Libro> disponibles = catalogo.obtenerLibrosDisponibles();
        assertEquals(1, disponibles.size());
    }
}
