package br.com.alura.catalogo_livros.service;

import br.com.alura.catalogo_livros.client.GutenbergApiClient;
import br.com.alura.catalogo_livros.dto.AutorDTO;
import br.com.alura.catalogo_livros.dto.LivroDTO;
import br.com.alura.catalogo_livros.dto.LivroResponse;
import br.com.alura.catalogo_livros.model.Autor;
import br.com.alura.catalogo_livros.model.Livro;
import br.com.alura.catalogo_livros.repository.AutorRepository;
import br.com.alura.catalogo_livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private GutenbergApiClient apiClient;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public void buscarLivroETornarPersistente(String titulo) {
        LivroResponse resposta = apiClient.buscarLivroPorTitulo(titulo);

        if (resposta == null || resposta.getResultados().isEmpty()) {
            System.out.println("Nenhum livro encontrado com esse título.");
            return;
        }

        LivroDTO dto = resposta.getResultados().get(0);
        if (dto.getAutores().isEmpty()) {
            System.out.println("Livro encontrado, mas sem autor definido. Ignorado.");
            return;
        }

        Autor autor = buscarOuCriarAutor(dto.getAutores().get(0));

        if (livroRepository.existsByTituloAndAutor(dto.getTitulo(), autor)) {
            System.out.println("Livro já existe no banco de dados.");
            return;
        }

        Livro livro = new Livro(
                dto.getTitulo(),
                dto.getIdiomas().isEmpty() ? "desconhecido" : dto.getIdiomas().get(0),
                dto.getNumeroDownloads(),
                autor
        );

        livroRepository.save(livro);
        System.out.println("Livro salvo com sucesso:");
        System.out.println(livro);
    }

    private Autor buscarOuCriarAutor(AutorDTO autorDTO) {
        Optional<Autor> autorOptional = autorRepository.findByNome(autorDTO.getNome());
        return autorOptional.orElseGet(() -> {
            Autor novoAutor = new Autor(
                    autorDTO.getNome(),
                    autorDTO.getAnoNascimento() != null ? LocalDate.of(autorDTO.getAnoNascimento(), 1, 1) : null,
                    autorDTO.getAnoFalecimento() != null ? LocalDate.of(autorDTO.getAnoFalecimento(), 1, 1) : null
            );
            return autorRepository.save(novoAutor);
        });
    }

    public void listarLivrosPorIdioma(String idioma) {
        List<Livro> livros = livroRepository.findByIdioma(idioma);
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado nesse idioma.");
        } else {
            livros.forEach(System.out::println);
        }
    }

    public void listarLivrosRegistrados() {
        List<Livro> livros = livroRepository.findAll();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro registrado no banco de dados.");
        } else {
            livros.forEach(System.out::println);
        }
    }

    public void estatisticasDeDownloads() {
        List<Livro> livros = livroRepository.findAll();
        DoubleSummaryStatistics stats = livros.stream()
                .mapToDouble(Livro::getNumeroDownloads)
                .summaryStatistics();

        System.out.println("Estatísticas de downloads:");
        System.out.println("Total: " + stats.getCount());
        System.out.println("Soma: " + stats.getSum());
        System.out.println("Média: " + stats.getAverage());
        System.out.println("Máximo: " + stats.getMax());
        System.out.println("Mínimo: " + stats.getMin());
    }

    public void top10MaisBaixados() {
        List<Livro> livros = livroRepository.findTop10ByOrderByNumeroDownloadsDesc();
        livros.forEach(System.out::println);
    }
}






