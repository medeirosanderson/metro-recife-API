package com.anderson.metrorecife.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.anderson.metrorecife.model.Estacao;
import com.anderson.metrorecife.service.EstacaoService;

@RestController
@RequestMapping("/estacoes")
public class EstacaoController {

    private final EstacaoService estacaoService;

    public EstacaoController(EstacaoService estacaoService) {
        this.estacaoService = estacaoService;
    }

    @GetMapping
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

    @GetMapping("/{id}")
    public Estacao buscarPorId(@PathVariable Integer id){
        return estacaoService.buscarPorId(id);
    }
}
