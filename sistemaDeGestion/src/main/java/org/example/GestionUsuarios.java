package org.example;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class GestionUsuarios {

    private final SistemaPrestamos sistemaPrestamos;
    Map<String, Usuario> usuarios = new HashMap<>();

    public void registrarUsuario(String nombre) {
        usuarios.putIfAbsent(nombre, Usuario.builder().nombre(nombre).build());
    }

    public void registrarPrestamo(String nombreUsuario, String isbn) {
        Usuario usuario = usuarios.get(nombreUsuario);
        if (usuario != null) {
            Prestamo prestamo = sistemaPrestamos.prestarLibro(isbn);
            if (prestamo != null) {
                usuario.agregarPrestamo(prestamo);
            }
        }
    }
}
