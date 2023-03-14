package com.rapidexTransportadoraAPI.api.assembler;

import com.rapidexTransportadoraAPI.api.assembler.generic.ObjectInputDisassembler;
import com.rapidexTransportadoraAPI.api.model.input.ClienteInput;
import com.rapidexTransportadoraAPI.domain.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteInputDisassembler extends ObjectInputDisassembler<ClienteInput, Cliente> {
}
