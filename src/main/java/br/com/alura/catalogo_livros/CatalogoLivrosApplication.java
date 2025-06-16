package br.com.alura.catalogo_livros;

import br.com.alura.catalogo_livros.menu.MenuConsole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CatalogoLivrosApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CatalogoLivrosApplication.class, args);
		MenuConsole menu = context.getBean(MenuConsole.class);
		menu.exibirMenu();
	}
}




