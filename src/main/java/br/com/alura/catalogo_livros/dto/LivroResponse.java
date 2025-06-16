package br.com.alura.catalogo_livros.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LivroResponse {

    @JsonProperty("results")
    private List<LivroDTO> resultados;

    public List<LivroDTO> getResultados() {
        return resultados;
    }
}


