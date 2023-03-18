package com.rapidexTransportadoraAPI.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteInput {
    String nome;
    String cpf;
    String email;
    String telefone;
}
