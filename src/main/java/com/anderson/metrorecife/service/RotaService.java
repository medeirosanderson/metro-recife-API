package com.anderson.metrorecife.service;

import com.anderson.metrorecife.model.Estacao;
import org.springframework.stereotype.Service;

@Service
public class RotaService {

    private final EstacaoService estacaoService;
    private final TrechoService trechoService;
    private final CalculadoraRota calculadoraRota;

    public RotaService(EstacaoService estacaoService,
        TrechoService trechoService) {

        this.estacaoService = estacaoService;
        this.trechoService = trechoService;
        this.calculadoraRota = new CalculadoraRota(trechoService.todosTrechos());
    }

    public double calcularDistancia(Integer origemId, Integer destinoId) {

        Estacao origem = estacaoService.buscarPorId(origemId);
        Estacao destino = estacaoService.buscarPorId(destinoId);

        return calculadoraRota.calcularDistancia(origem, destino);
    }

    public double calcularTempo(Integer origemId, Integer destinoId){
        Estacao origem = estacaoService.buscarPorId(origemId);
        Estacao destino = estacaoService.buscarPorId(destinoId);

        return calculadoraRota.calcularTempoMinutos(origem, destino);
    }
}
