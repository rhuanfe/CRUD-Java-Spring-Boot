package com.example.teste.business;

import com.example.teste.infrastructure.entitys.Filme;
import com.example.teste.infrastructure.repository.FilmeRepository;
import org.springframework.stereotype.Service;


@Service
public class FilmeService {
    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public void salvarFilme(Filme filme){
        repository.saveAndFlush(filme);
    }

    public Filme buscarFilmePorNome(String nome){
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Filme não encontrado")
        );
    }

    public void deletarFilmePorNome(String nome){
        repository.deleteByNome(nome);
    }

    public void atualizarFilmePorId(Integer id, Filme filme){
        // Aqui todos os campos são obrigatórios
        Filme filmeExistente = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Filme não encontrado"));

        Filme filmeAtualizado = Filme.builder()
                .id(filmeExistente.getId())
                .nome(filme.getNome())
                .diretor(filme.getDiretor())
                .build();

        repository.saveAndFlush(filmeAtualizado);
    }
}
