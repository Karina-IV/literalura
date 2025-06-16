package br.com.alura.catalogo_livros.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LivroDTO {

    @JsonProperty("title")
    private String titulo;

    @JsonProperty("languages")
    private List<String> idiomas;

    @JsonProperty("download_count")
    private Integer numeroDownloads;

    @JsonProperty("authors")
    private List<AutorDTO> autores;

    public String getTitulo() {
        return titulo;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public List<AutorDTO> getAutores() {
        return autores;
    }
}



