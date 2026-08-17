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
        estacoes.add(new Estacao(5, "Mangueira", "Centro"));
        estacoes.add(new Estacao(6, "Santa Luzia", "Centro"));
        estacoes.add(new Estacao(7, "Werneck", "Centro"));
        estacoes.add(new Estacao(8, "Barro", "Centro"));
        estacoes.add(new Estacao(9, "Tejipió", "Centro"));
        estacoes.add(new Estacao(10, "Coqueiral", "Centro"));

        estacoes.add(new Estacao(11, "Alto do Céu", "Centro"));
        estacoes.add(new Estacao(12, "Curado", "Centro"));
        estacoes.add(new Estacao(13, "Rodoviária", "Centro"));
        estacoes.add(new Estacao(14, "Cosme e Damião", "Centro"));
        estacoes.add(new Estacao(15, "Camaragibe", "Centro"));

        estacoes.add(new Estacao(16, "Cavaleiro", "Centro"));
        estacoes.add(new Estacao(17, "Floriano", "Centro"));
        estacoes.add(new Estacao(18, "Engenho Velho", "Centro"));
        estacoes.add(new Estacao(19, "Jaboatão", "Centro"));

        estacoes.add(new Estacao(20, "Largo da Paz", "Sul"));
        estacoes.add(new Estacao(21, "Imbiribeira", "Sul"));
        estacoes.add(new Estacao(22, "Antônio Falcão", "Sul"));
        estacoes.add(new Estacao(23, "Shopping", "Sul"));
        estacoes.add(new Estacao(24, "Tancredo Neves", "Sul"));
        estacoes.add(new Estacao(25, "Aeroporto", "Sul"));
        estacoes.add(new Estacao(26, "Porta Larga", "Sul"));
        estacoes.add(new Estacao(27, "Monte dos Guararapes", "Sul"));
        estacoes.add(new Estacao(28, "Prazeres", "Sul"));
        estacoes.add(new Estacao(29, "Cajueiro Seco", "Sul"));
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
