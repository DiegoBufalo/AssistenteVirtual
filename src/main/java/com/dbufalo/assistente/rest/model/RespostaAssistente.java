package com.dbufalo.assistente.rest.model;

import com.dbufalo.assistente.persistence.entity.RespostaAssistenteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespostaAssistente implements Serializable {

    private static final long serialVersionUID=1l;

    private Integer id;

    private String resposta;


    public static RespostaAssistenteEntity fromModel(RespostaAssistente model){
        return
                new RespostaAssistenteEntity(
                        model.getId(),
                        model.getResposta()
                );
    }

    public static Mono<RespostaAssistente> fromEntity(RespostaAssistenteEntity entity){
        return Mono.just(entity)
                    .flatMap(x ->{
                        RespostaAssistente respostaAssistente = new RespostaAssistente();

                            respostaAssistente.setId(x.getId());
                            respostaAssistente.setResposta(x.getResposta());

                        return Mono.just(respostaAssistente);
                    });
    }

    public static Mono<RespostaAssistente> fromEntity(Mono<RespostaAssistenteEntity> entity){
        return entity
                .flatMap(x ->{
                    RespostaAssistente respostaAssistente = new RespostaAssistente();

                    respostaAssistente.setId(x.getId());
                    respostaAssistente.setResposta(x.getResposta());

                    return Mono.just(respostaAssistente);
                });
    }

}
