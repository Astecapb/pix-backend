package br.com.robson.pix_backend.controllers;

import br.com.robson.pix_backend.models.Sorteio;
import br.com.robson.pix_backend.services.SorteioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sorteios")
@RequiredArgsConstructor
public class SorteioController {

    private final SorteioService sorteioService;

    @GetMapping
    public List<Sorteio> listar() {
        return sorteioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sorteio> buscarPorId(@PathVariable Long id) {
        return sorteioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/iniciar")
    public ResponseEntity<Sorteio> iniciarSorteio(
            @RequestParam String numero,
            @RequestParam String inicio,
            @RequestParam String fim
    ) {
        LocalDate dataInicio = LocalDate.parse(inicio);
        LocalDate dataFim = LocalDate.parse(fim);

        Sorteio sorteio = sorteioService.iniciarSorteio(numero, dataInicio, dataFim);
        return ResponseEntity.ok(sorteio);
    }
}
