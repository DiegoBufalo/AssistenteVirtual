package com.dbufalo.assistente.persistence.entity;


import com.dbufalo.assistente.rest.model.RespostaAssistente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table("resposta_assistente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespostaAssistenteEntity implements Serializable {

    private static final long serialVersionUID= 1l;

    @Id
    @Column("id")
    private Integer id;

    @Column("resposta")
    private String resposta;

    public RespostaAssistenteEntity (RespostaAssistente respostaAssistente){
        super();
        this.id = respostaAssistente.getId();
        this.resposta = respostaAssistente.getResposta();
    }
}
