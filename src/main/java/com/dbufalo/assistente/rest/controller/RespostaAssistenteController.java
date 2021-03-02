package com.dbufalo.assistente.rest.controller;

import com.dbufalo.assistente.rest.model.RespostaAssistente;
import com.dbufalo.assistente.rest.service.RespostaAssistenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/chat")
public class RespostaAssistenteController {

    @Autowired
    private RespostaAssistenteService respostaService;

    @GetMapping
    public Mono<RespostaAssistente> apresentacaoAssistente(){
       return respostaService.apresentacaoInicial();
    }

    @PostMapping("conversa")
    public Mono<RespostaAssistente> respostas(@RequestBody RespostaAssistente palavra){
        return respostaService.buscarResposta(palavra);

    }
}
