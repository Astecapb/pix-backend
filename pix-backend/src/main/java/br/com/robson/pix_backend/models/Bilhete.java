package br.com.robson.pix_backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bilhetes")
public class Bilhete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private boolean premiado;

    private LocalDate dataCompra;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
