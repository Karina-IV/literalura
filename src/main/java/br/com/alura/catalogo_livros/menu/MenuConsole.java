package br.com.alura.catalogo_livros.menu;

import br.com.alura.catalogo_livros.service.AutorService;
import br.com.alura.catalogo_livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuConsole {

    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;

    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== Catálogo LiterAlura =====");
            System.out.println("1 - Buscar livro por título e salvar");
            System.out.println("2 - Listar livros por idioma");
            System.out.println("3 - Listar todos os livros");
            System.out.println("4 - Listar todos os autores");
            System.out.println("5 - Listar autores vivos em determinado ano");
            System.out.println("6 - Buscar autor por nome");
            System.out.println("7 - Estatísticas de downloads");
            System.out.println("8 - Top 10 livros mais baixados");
            System.out.println("0 - Sair");
            System.out.print("Escolha sua opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                executarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }
    }

    private void executarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> buscarLivroPorTitulo();
            case 2 -> listarLivrosPorIdioma();
            case 3 -> livroService.listarLivrosRegistrados();
            case 4 -> autorService.listarAutores();
            case 5 -> listarAutoresVivos();
            case 6 -> buscarAutorPorNome();
            case 7 -> livroService.estatisticasDeDownloads();
            case 8 -> livroService.top10MaisBaixados();
            case 0 -> System.out.println("Encerrando o programa.");
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void buscarLivroPorTitulo() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        livroService.buscarLivroETornarPersistente(titulo);
    }

    private void listarLivrosPorIdioma() {
        System.out.print("Digite o idioma (ex: en, pt, es, etc): ");
        String idioma = scanner.nextLine();
        livroService.listarLivrosPorIdioma(idioma);
    }

    private void listarAutoresVivos() {
        System.out.print("Digite o ano para consultar autores vivos: ");
        int ano = Integer.parseInt(scanner.nextLine());
        autorService.listarAutoresVivosNoAno(ano);
    }

    private void buscarAutorPorNome() {
        System.out.print("Digite o nome do autor: ");
        String nome = scanner.nextLine();
        autorService.buscarAutorPorNome(nome);
    }
}






