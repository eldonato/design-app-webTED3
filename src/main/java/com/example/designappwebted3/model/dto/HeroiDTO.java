package com.example.designappwebted3.model.dto;

import lombok.Data;

@Data
public class HeroiDTO {
    private Long id;
    private String nomeHeroi;
    private String primeiroNome;
    private String ultimoNome;
    private String local;
    private int idade;
}
