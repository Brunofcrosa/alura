package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nome);

}
