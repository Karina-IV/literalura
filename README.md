# 📚 LiterAlura - Catálogo de Livros

Bem-vindo(a) ao projeto **LiterAlura**, uma aplicação desenvolvida em Java com Spring Boot que permite buscar, armazenar e consultar livros e autores, utilizando dados da API do Gutendex.

---

## 🚀 Funcionalidades

- 🔎 Buscar livros por título e salvar no banco de dados
- 📚 Listar livros por idioma
- 📖 Listar todos os livros
- ✍️ Listar todos os autores
- 🧃 Listar autores vivos em determinado ano
- 👤 Buscar autor por nome
- 📊 Estatísticas de downloads dos livros
- 🏆 Top 10 livros mais baixados
- 🔒 Evita duplicatas de livros e autores

---

## 💠 Tecnologias utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- PostgreSQL
- API Gutendex ([https://gutendex.com/](https://gutendex.com/))
- Maven

---

## 🌟 Como executar o projeto

### Pré-requisitos:

- Java 21 instalado
- PostgreSQL rodando
- IDE de sua preferência (IntelliJ, Eclipse, VS Code, etc)

### Passos:

1️⃣ Clone o repositório:

```bash
git clone https://github.com/seu-usuario/literalura.git
```

2️⃣ Crie o banco de dados no PostgreSQL:

```sql
CREATE DATABASE catalogo_livros;
```

3️⃣ Configure o arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/catalogo_livros
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
```

4️⃣ Rode o projeto na sua IDE ou pelo terminal:

```bash
./mvnw spring-boot:run
```

5️⃣ O menu será exibido no console e você poderá interagir com o sistema!

---

## 💻 Estrutura do projeto

```
src
 └── main
      └── java
           └── br.com.alura.catalogo_livros
                ├── model
                ├── repository
                ├── service
                ├── client
                └── menu
      └── resources
           └── application.properties
```

---

## 📸 Exemplo de uso:

```text
===== Catálogo LiterAlura =====
1 - Buscar livro por título e salvar
2 - Listar livros por idioma
3 - Listar todos os livros
4 - Listar todos os autores
5 - Listar autores vivos em determinado ano
6 - Buscar autor por nome
7 - Estatísticas de downloads
8 - Top 10 livros mais baixados
0 - Sair
```

---

## 👩‍💼 Desenvolvedora

- **Karina Ivanova Varlamova**

---

## ⭐ Agradecimentos

Alura & Oracle

---

## 📄 Licença

Este projeto é livre para uso educacional.
