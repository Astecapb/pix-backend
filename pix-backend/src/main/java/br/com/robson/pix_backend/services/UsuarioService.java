package br.com.robson.pix_backend.services;

import br.com.robson.pix_backend.models.Bilhete;
import br.com.robson.pix_backend.models.Usuario;
import br.com.robson.pix_backend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public List<Bilhete> listarBilhetesDoUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return usuario.getBilhete();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario cadastrar(Usuario usuario) {
        boolean cpfExiste = usuarioRepository.existsByCpf(usuario.getCpf());
        boolean emailExiste = usuarioRepository.existsByEmail(usuario.getEmail());

        if (cpfExiste || emailExiste) {
            throw new RuntimeException("CPF ou Email já cadastrado.");
        }

        return usuarioRepository.save(usuario);
    }


    public Usuario atualizar(Long id, Usuario novoUsuario) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(novoUsuario.getNome());
            usuario.setCpf(novoUsuario.getCpf());
            usuario.setEmail(novoUsuario.getEmail());
            usuario.setTelefone(novoUsuario.getTelefone());
            usuario.setEndereco(novoUsuario.getEndereco());
            usuario.setDataNascimento(novoUsuario.getDataNascimento());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
