package br.com.alura.catalogo_livros.repository;

import br.com.alura.catalogo_livros.model.Autor;
import br.com.alura.catalogo_livros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    boolean existsByTituloAndAutor(String titulo, Autor autor);
    List<Livro> findByIdioma(String idioma);
    List<Livro> findTop10ByOrderByNumeroDownloadsDesc();
}







