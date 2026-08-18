package com.anderson.metrorecife.service;

import com.anderson.metrorecife.model.Estacao;
import com.anderson.metrorecife.model.Trecho;

import java.util.List;

public class CalculadoraRota {

    private List<Trecho> trechos;

    public CalculadoraRota(List<Trecho> trechos) {
        this.trechos = trechos;
    }

    public double calcularDistancia(Estacao origem, Estacao destino) {

        double distanciaTotal = 0;
        boolean encontrouOrigem = false;

        for (Trecho trecho : trechos) {

            if (trecho.getOrigem().getId() == origem.getId()) {
                encontrouOrigem = true;
            }

            if (encontrouOrigem) {
                distanciaTotal += trecho.getDistancia();

                if (trecho.getDestino().getId() == destino.getId()) {
                    return distanciaTotal;
                }
            }
        }

        return 0;
    }
}