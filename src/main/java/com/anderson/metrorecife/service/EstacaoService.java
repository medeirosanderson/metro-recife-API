package com.anderson.metrorecife.service;

import com.anderson.metrorecife.exception.EstacaoNaoEncontradaException;
import com.anderson.metrorecife.model.Estacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class EstacaoService {

    private List<Estacao> estacoes = new ArrayList<>();
    
    public EstacaoService(){
        estacoes.add(new Estacao(1, "Recife", "Centro"));
        estacoes.add(new Estacao(2, "Joana Bezerra", "Centro"));
        estacoes.add(new Estacao(3, "Afogados", "Centro"));
        estacoes.add(new Estacao(4, "Ipiranga", "Centro"));
        estacoes.add(new Estacao(5, "Jaboatao", "Jaboatao"));
        estacoes.add(new Estacao(6, "Cavaleiro", "Jaboatao"));
        }

    public List<Estacao> todasEstacoes(){
        return estacoes;
    }

    public List<Estacao> buscarLinha(String linha){
        List<Estacao> buscarLinha = estacoes.stream()
        .filter(estacao -> estacao.getLinha().toLowerCase().contains(linha.toLowerCase()))
        .toList();

        return buscarLinha;
    }

    public List<Estacao> buscarEstacao(String nome){
        List<Estacao> buscarEstacao = estacoes.stream()
        .filter(estacao -> estacao.getNome().toLowerCase().contains(nome.toLowerCase()))
        .collect(Collectors.toList());

        return buscarEstacao;
    }

    public Estacao buscarPorId (Integer id){
        Optional<Estacao> buscarId = estacoes.stream()
        .filter(estacao -> estacao.getId() == id)
        .findFirst();
    
            return buscarId.orElseThrow(() -> new EstacaoNaoEncontradaException("Estação com ID: " + id + " Não encontrada."));
    } 
}
