package br.com.robson.pix_backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sorteios")
public class Sorteio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private LocalDate dataSorteio;

    private LocalDate dataInicio;

    private LocalDate dataFim;
}
