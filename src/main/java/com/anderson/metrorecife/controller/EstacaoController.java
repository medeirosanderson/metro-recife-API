package com.anderson.metrorecife.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.anderson.metrorecife.model.Estacao;
import com.anderson.metrorecife.service.EstacaoService;

@RestController
public class EstacaoController {

    private final EstacaoService estacaoService;

    public EstacaoController(EstacaoService estacaoService) {
        this.estacaoService = estacaoService;
    }

    @GetMapping("/estacoes")
    public List<Estacao> mostrarEstacoes(){
        return estacaoService.todasEstacoes();
    }

    @GetMapping("/buscarlinha")
    public List<Estacao> buscarLinha(@RequestParam String linha){
        return estacaoService.buscarLinha(linha);
    }

    @GetMapping("/buscarestacao")
    public List<Estacao> buscarEstacao(@RequestParam String nome){
        return estacaoService.buscarEstacao(nome);
    }
}
