package com.anderson.metrorecife.service;

import com.anderson.metrorecife.model.Estacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EstacaoService {

    public List<Estacao> listarEstacoes() {

        List<Estacao> estacoes = new ArrayList<>();

        estacoes.add(new Estacao("Recife"));
        estacoes.add(new Estacao("Joana Bezerra"));
        estacoes.add(new Estacao("Afogados"));
        estacoes.add(new Estacao("Ipiranga"));

        return estacoes;
    }
}
