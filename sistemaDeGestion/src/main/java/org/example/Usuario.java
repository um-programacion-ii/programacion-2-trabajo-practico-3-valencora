package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    private String nombre;
    @Builder.Default
    private List<Prestamo> historialPrestamos = new ArrayList<>();

    public void agregarPrestamo(Prestamo prestamo) {
        historialPrestamos.add(prestamo);
    }
}
