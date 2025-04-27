package org.example;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class GestionUsuariosTest {

    @Mock
    private Catalogo catalogo;

    @Mock
    private SistemaPrestamos sistemaPrestamos;

    @InjectMocks
    private GestionUsuarios gestionUsuarios;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gestionUsuarios.registrarUsuario("usuario1");
    }

    @Test
    void testRegistrarPrestamo() {
        Libro libro = Libro.builder()
                .isbn("978-3-16-148410-0")
                .titulo("Clean Code")
                .autor("Robert C. Martin")
                .estado(Estado.DISPONIBLE)
                .build();

        when(catalogo.buscarPorIsbn("978-3-16-148410-0")).thenReturn(libro);
        when(sistemaPrestamos.prestarLibro("978-3-16-148410-0"))
                .thenReturn(new Prestamo(libro, LocalDate.now()));

        gestionUsuarios.registrarPrestamo("usuario1", "978-3-16-148410-0");

        Usuario usuario = gestionUsuarios.usuarios.get("usuario1");

        verify(sistemaPrestamos).prestarLibro("978-3-16-148410-0");
        assertEquals(1, usuario.getHistorialPrestamos().size());
    }

}
