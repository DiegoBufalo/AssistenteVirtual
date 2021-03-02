package com.dbufalo.assistente.persistence.repository;

import com.dbufalo.assistente.persistence.entity.RespostaAssistenteEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RespostaAssistenteRepository extends ReactiveCrudRepository<RespostaAssistenteEntity, Integer> {

    Mono<RespostaAssistenteEntity> findFirstByRespostaContainingIgnoringCase(String palavra);

}
