package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Prestamo {
    private Libro libro;
    private LocalDate fechaPrestamo = LocalDate.now();
}
