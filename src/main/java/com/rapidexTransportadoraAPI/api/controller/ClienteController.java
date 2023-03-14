package com.rapidexTransportadoraAPI.api.controller;

import com.rapidexTransportadoraAPI.api.assembler.ClienteModelAssembler;
import com.rapidexTransportadoraAPI.api.model.ClienteModel;
import com.rapidexTransportadoraAPI.domain.model.Cliente;
import com.rapidexTransportadoraAPI.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteModelAssembler clienteModelAssembler;


    @GetMapping
    public ResponseEntity<ClienteModel> buscarPorId(@PathVariable Long idCliente) {
        Cliente cliente = clienteService.buscarPorId(idCliente);

        return ResponseEntity.ok(clienteModelAssembler.toModel(cliente));
    }

}
