package com.example.teste.infrastructure.repository;

import com.example.teste.infrastructure.entitys.Filme;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    Optional<Filme> findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);
}
