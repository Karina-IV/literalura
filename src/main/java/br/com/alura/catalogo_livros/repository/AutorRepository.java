package br.com.alura.catalogo_livros.repository;

import br.com.alura.catalogo_livros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNome(String nome);
    List<Autor> findByNomeContainingIgnoreCase(String nome);
    List<Autor> findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqual(LocalDate nascimento, LocalDate falecimento);
}



