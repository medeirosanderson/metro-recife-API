package com.anderson.metrorecife.service;

import com.anderson.metrorecife.model.Estacao;
import com.anderson.metrorecife.model.Trecho;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrechoService {

    private List<Trecho> trechos = new ArrayList<>();

    public TrechoService(EstacaoService estacaoService) {

        Estacao recife = estacaoService.buscarPorId(1);
        Estacao joanaBezerra = estacaoService.buscarPorId(2);
        Estacao afogados = estacaoService.buscarPorId(3);
        Estacao ipiranga = estacaoService.buscarPorId(4);
        Estacao mangueira = estacaoService.buscarPorId(5);
        Estacao santaLuzia = estacaoService.buscarPorId(6);
        Estacao werneck = estacaoService.buscarPorId(7);
        Estacao barro = estacaoService.buscarPorId(8);
        Estacao tejipio = estacaoService.buscarPorId(9);
        Estacao coqueiral = estacaoService.buscarPorId(10);
        Estacao altoDoCeu = estacaoService.buscarPorId(11);
        Estacao curado = estacaoService.buscarPorId(12);
        Estacao rodoviaria = estacaoService.buscarPorId(13);
        Estacao cosmeEDamiao = estacaoService.buscarPorId(14);
        Estacao camaragibe = estacaoService.buscarPorId(15);

        trechos.add(new Trecho(recife, joanaBezerra, 1.5));
        trechos.add(new Trecho(joanaBezerra, afogados, 1.8));
        trechos.add(new Trecho(afogados, ipiranga, 1.2));
        trechos.add(new Trecho(ipiranga, mangueira, 1.1));
        trechos.add(new Trecho(mangueira, santaLuzia, 1.0));
        trechos.add(new Trecho(santaLuzia, werneck, 1.2));
        trechos.add(new Trecho(werneck, barro, 1.5));
        trechos.add(new Trecho(barro, tejipio, 1.4));
        trechos.add(new Trecho(tejipio, coqueiral, 1.3));
        trechos.add(new Trecho(coqueiral, altoDoCeu, 2.0));
        trechos.add(new Trecho(altoDoCeu, curado, 1.5));
        trechos.add(new Trecho(curado, rodoviaria, 1.2));
        trechos.add(new Trecho(rodoviaria, cosmeEDamiao, 1.4));
        trechos.add(new Trecho(cosmeEDamiao, camaragibe, 2.0));
    }

    public List<Trecho> todosTrechos() {
        return trechos;
    }

    public Trecho buscarTrecho(Estacao origem, Estacao destino) {
    return trechos.stream()
            .filter(trecho ->
                    (trecho.getOrigem().getId() == origem.getId()
                    && trecho.getDestino().getId() == destino.getId())

                    ||

                    (trecho.getOrigem().getId() == destino.getId()
                    && trecho.getDestino().getId() == origem.getId())
            )
            .findFirst()
            .orElse(null);
    }
}