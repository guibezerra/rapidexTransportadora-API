package com.rapidexTransportadoraAPI.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteModel {
    String idCliente;
    String nome;
    String cpf;
    String email;
    String telefone;
}
