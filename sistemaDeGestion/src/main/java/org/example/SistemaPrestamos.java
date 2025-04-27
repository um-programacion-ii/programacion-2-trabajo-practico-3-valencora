package org.example;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class SistemaPrestamos {

    private final Catalogo catalogo;

    public Prestamo prestarLibro(String isbn) {
        Libro libro = catalogo.buscarPorIsbn(isbn);
        if (libro == null || libro.getEstado() != Estado.DISPONIBLE) {
            return null;
        }
        libro.setEstado(Estado.PRESTADO);
        return new Prestamo(libro, LocalDate.now());
    }
}
