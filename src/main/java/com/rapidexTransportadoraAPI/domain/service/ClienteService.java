package com.rapidexTransportadoraAPI.domain.service;

import com.rapidexTransportadoraAPI.api.model.ClienteModel;
import com.rapidexTransportadoraAPI.api.model.input.ClienteInput;
import com.rapidexTransportadoraAPI.domain.model.Cliente;
import com.rapidexTransportadoraAPI.domain.repository.ClienteRepository;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    @Transactional
    public Cliente buscarPorId(long idCliente) {
        return clienteRepository.findById(idCliente).orElseThrow(() ->new RuntimeException());
    }

    @Transactional
    public Page<Cliente> buscarTodos(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Transactional
    public Cliente cadastrar(Cliente cliente) {

        return clienteRepository.save(cliente);
    }
}
