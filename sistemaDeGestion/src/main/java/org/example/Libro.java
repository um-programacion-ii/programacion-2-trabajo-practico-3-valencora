package org.example;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Estado;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    @Builder.Default
    private Estado estado = Estado.DISPONIBLE;


}
