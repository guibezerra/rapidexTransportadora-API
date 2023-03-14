package com.rapidexTransportadoraAPI.api.assembler;

import com.rapidexTransportadoraAPI.api.assembler.generic.ObjectModelAssembler;
import com.rapidexTransportadoraAPI.api.model.ClienteModel;
import com.rapidexTransportadoraAPI.domain.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteModelAssembler extends ObjectModelAssembler<ClienteModel, Cliente> {
}
