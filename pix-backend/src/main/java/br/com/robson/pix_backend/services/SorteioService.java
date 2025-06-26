package br.com.robson.pix_backend.services;

import br.com.robson.pix_backend.models.Sorteio;
import br.com.robson.pix_backend.repositories.SorteioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class SorteioService {

    private final SorteioRepository sorteioRepository;

    public List<Sorteio> listarTodos() {
        return sorteioRepository.findAll();
    }

    public Optional<Sorteio> buscarPorId(Long id) {
        return sorteioRepository.findById(id);
    }

    public Sorteio iniciarSorteio(String numero, LocalDate inicio, LocalDate fim) {
        Sorteio sorteio = new Sorteio();
        sorteio.setNumero(numero);
        sorteio.setDataInicio(inicio);
        sorteio.setDataFim(fim);
        sorteio.setDataSorteio(LocalDate.now());

        return sorteioRepository.save(sorteio);
    }
}
