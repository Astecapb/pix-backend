package br.com.robson.pix_backend.services;

import br.com.robson.pix_backend.models.Bilhete;
import br.com.robson.pix_backend.models.Usuario;
import br.com.robson.pix_backend.repositories.BilheteRepository;
import br.com.robson.pix_backend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BilheteService {

    private final BilheteRepository bilheteRepository;
    private final UsuarioRepository usuarioRepository;

    public Bilhete gerarBilhete(Long usuarioId, String numero) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Bilhete bilhete = new Bilhete();
        bilhete.setNumero(numero);
        bilhete.setPremiado(false);
        bilhete.setDataCompra(LocalDate.now());
        bilhete.setUsuario(usuario);

        return bilheteRepository.save(bilhete);
    }

    public List<Bilhete> listarTodos() {
        return bilheteRepository.findAll();
    }

    public Bilhete marcarPremiado(Long bilheteId) {
        Bilhete bilhete = bilheteRepository.findById(bilheteId)
                .orElseThrow(() -> new RuntimeException("Bilhete não encontrado"));
        bilhete.setPremiado(true);
        return bilheteRepository.save(bilhete);
    }
}
