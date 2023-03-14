package com.rapidexTransportadoraAPI.domain.service;

import com.rapidexTransportadoraAPI.domain.model.Cliente;
import com.rapidexTransportadoraAPI.domain.repository.ClienteRepository;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente buscarPorId(long idCliente) {
        return clienteRepository.findById(idCliente).orElseThrow(() ->new RuntimeException());
    }
}
