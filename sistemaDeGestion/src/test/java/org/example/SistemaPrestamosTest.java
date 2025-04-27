package org.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SistemaPrestamosTest {

    @Mock
    private Catalogo catalogo;

    @InjectMocks
    private SistemaPrestamos sistemaPrestamos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPrestarLibroExitoso() {
        Libro libro = Libro.builder()
                .isbn("978-3-16-148410-0")
                .titulo("Clean Code")
                .autor("Robert C. Martin")
                .estado(Estado.DISPONIBLE)
                .build();

        when(catalogo.buscarPorIsbn("978-3-16-148410-0")).thenReturn(libro);

        Prestamo prestamo = sistemaPrestamos.prestarLibro("978-3-16-148410-0");

        assertNotNull(prestamo);
        assertEquals(Estado.PRESTADO, libro.getEstado());
        verify(catalogo).buscarPorIsbn("978-3-16-148410-0");
    }

    @Test
    void testPrestarLibroFallido() {
        when(catalogo.buscarPorIsbn("000-0-00-000000-0")).thenReturn(null);

        Prestamo prestamo = sistemaPrestamos.prestarLibro("000-0-00-000000-0");

        assertNull(prestamo);
        verify(catalogo).buscarPorIsbn("000-0-00-000000-0");
    }
}
