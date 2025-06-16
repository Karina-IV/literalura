package br.com.alura.catalogo_livros.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AutorDTO {

    @JsonProperty("name")
    private String nome;

    @JsonProperty("birth_year")
    private Integer anoNascimento;

    @JsonProperty("death_year")
    private Integer anoFalecimento;

    public String getNome() {
        return nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }
}



