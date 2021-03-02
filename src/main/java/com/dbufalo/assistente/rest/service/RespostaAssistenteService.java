package com.dbufalo.assistente.rest.service;

import com.dbufalo.assistente.persistence.entity.RespostaAssistenteEntity;
import com.dbufalo.assistente.persistence.repository.RespostaAssistenteRepository;
import com.dbufalo.assistente.rest.model.RespostaAssistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RespostaAssistenteService {

    private static final String MESSAGE_RESPOSTA_NOTFOUND="Desculpe, nao entendi sua pergunta";

    @Autowired
    private RespostaAssistenteRepository respostaRepository;


    public Mono<RespostaAssistente> apresentacaoInicial(){
        return this.respostaRepository.findById(1)
                .flatMap(RespostaAssistente::fromEntity);
    }

    public Mono<RespostaAssistente> buscarResposta(RespostaAssistente palavra){
        return Mono.just(palavra)
                    .flatMap(x ->{
                        Mono<RespostaAssistenteEntity> respostaEncontrada =
                                this.respostaRepository.findFirstByRespostaContainingIgnoringCase(
                                    x.getResposta());
                        return Mono.just(respostaEncontrada)
                                .flatMap(RespostaAssistente::fromEntity);
                    })
                .defaultIfEmpty(
                        new RespostaAssistente(
                                2,
                                MESSAGE_RESPOSTA_NOTFOUND));
    }
}
