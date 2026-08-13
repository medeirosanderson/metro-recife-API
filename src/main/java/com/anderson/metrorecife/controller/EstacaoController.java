package com.anderson.metrorecife.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstacaoController {
    @GetMapping("/estacoes")
    public String listarEstacoes(){
        return "Estações do Metrô do Recife";
    }
}
