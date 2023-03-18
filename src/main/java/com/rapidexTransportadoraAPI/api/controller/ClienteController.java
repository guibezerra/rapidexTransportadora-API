package com.rapidexTransportadoraAPI.api.controller;

import com.rapidexTransportadoraAPI.api.assembler.ClienteInputDisassembler;
import com.rapidexTransportadoraAPI.api.assembler.ClienteModelAssembler;
import com.rapidexTransportadoraAPI.api.model.ClienteModel;
import com.rapidexTransportadoraAPI.api.model.input.ClienteInput;
import com.rapidexTransportadoraAPI.domain.model.Cliente;
import com.rapidexTransportadoraAPI.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteModelAssembler clienteModelAssembler;

    @Autowired
    ClienteInputDisassembler clienteInputDisassembler;

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteModel> buscarPorId(@PathVariable Long idCliente) {
        Cliente cliente = clienteService.buscarPorId(idCliente);

        return ResponseEntity.ok(clienteModelAssembler.toModel(cliente));
    }

    @GetMapping
    public Page<ClienteModel> buscarTodosOsClientes(@PageableDefault(size = 10) Pageable pageable) {
        Page<Cliente> clientesPage = clienteService.buscarTodos(pageable);

        return retornaClientesPaginados(clientesPage, pageable);
    }

    private Page<ClienteModel> retornaClientesPaginados(Page<Cliente> clientesPage, Pageable pageable) {
        return new PageImpl<>(clienteModelAssembler.toCollectionModel(clientesPage.getContent()),
                              pageable,
                              clientesPage.getTotalElements());
    }

    @PostMapping
    public ResponseEntity<ClienteModel> cadastrarCliente(@RequestBody ClienteInput clienteInput) throws URISyntaxException {
        Cliente cliente = clienteInputDisassembler.toDomainObject(clienteInput);

        cliente = clienteService.cadastrar(cliente);

        URI location = new URI("/clientes");

        ClienteModel clienteModel = clienteModelAssembler.toModel(cliente);

        return ResponseEntity.created(location).body(clienteModel);
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteModel> atualizarCliente(@PathVariable Long idCliente, @RequestBody ClienteInput clienteInput) {
        Cliente clienteAtual = clienteService.buscarPorId(idCliente);

        clienteInputDisassembler.copyToDomainObject(clienteInput, clienteAtual);

        clienteAtual = clienteService.cadastrar(clienteAtual);

        ClienteModel clienteModel = clienteModelAssembler.toModel(clienteAtual);

        return ResponseEntity.ok().body(clienteModel);
    }
}
