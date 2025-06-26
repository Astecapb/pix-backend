package br.com.robson.pix_backend.controllers;

import br.com.robson.pix_backend.models.Bilhete;
import br.com.robson.pix_backend.services.BilheteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bilhetes")
@RequiredArgsConstructor
public class BilheteController {

    private final BilheteService bilheteService;

    @GetMapping
    public List<Bilhete> listarTodos() {
        return bilheteService.listarTodos();
    }

    @PostMapping("/gerar")
    public ResponseEntity<Bilhete> gerarBilhete(@RequestParam Long usuarioId, @RequestParam String numero) {
        return ResponseEntity.ok(bilheteService.gerarBilhete(usuarioId, numero));
    }

    @PatchMapping("/premiar/{id}")
    public ResponseEntity<Bilhete> premiar(@PathVariable Long id) {
        return ResponseEntity.ok(bilheteService.marcarPremiado(id));
    }
}
