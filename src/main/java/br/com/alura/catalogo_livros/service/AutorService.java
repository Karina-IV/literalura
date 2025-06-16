package br.com.alura.catalogo_livros.service;

import br.com.alura.catalogo_livros.model.Autor;
import br.com.alura.catalogo_livros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public void listarAutores() {
        List<Autor> autores = autorRepository.findAll();
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor registrado.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    public void listarAutoresVivosNoAno(int anoConsulta) {
        LocalDate dataConsulta = LocalDate.of(anoConsulta, 1, 1);
        List<Autor> autoresVivos = autorRepository.findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqual(dataConsulta, dataConsulta);
        if (autoresVivos.isEmpty()) {
            System.out.println("Nenhum autor vivo no ano informado.");
        } else {
            autoresVivos.forEach(System.out::println);
        }
    }

    public void buscarAutorPorNome(String nome) {
        List<Autor> autores = autorRepository.findByNomeContainingIgnoreCase(nome);
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado com o nome: " + nome);
        } else {
            autores.forEach(System.out::println);
        }
    }
}




