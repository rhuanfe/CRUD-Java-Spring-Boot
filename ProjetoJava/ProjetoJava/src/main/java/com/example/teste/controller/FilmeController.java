package com.example.teste.controller;

import com.example.teste.business.FilmeService;
import com.example.teste.infrastructure.entitys.Filme;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @PostMapping
    public ResponseEntity<Void> salvarFilme(@RequestBody Filme filme){
        filmeService.salvarFilme(filme);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Filme> buscarFilmePorNome(@RequestParam String nome){
        return ResponseEntity.ok(filmeService.buscarFilmePorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarFilmePorNome(@RequestParam String nome){
        filmeService.deletarFilmePorNome(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarFilmePorId(@RequestParam Integer id,
                                                    @RequestBody Filme filme){
        filmeService.atualizarFilmePorId(id, filme);
        return ResponseEntity.ok().build();
    }
}
