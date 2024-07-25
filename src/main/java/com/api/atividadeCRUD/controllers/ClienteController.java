package com.api.atividadeCRUD.controllers;

import org.springframework.web.bind.annotation.*;

import com.api.atividadeCRUD.classes.Cliente;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    // Simulação de um banco de dados em memória
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    // Get all clients
    @GetMapping
    public String getAllClientes() {
        if (Cliente.clientes.isEmpty()) {
            return "Não há clientes cadastrados.";
        } else {
            String resposta = Cliente.clientes.toString();
            return resposta;
        }
    }

    // Criar um cliente - Create
    @PostMapping
    public String createCliente(@RequestBody Cliente cliente) {
        clientes.add(cliente);
        return "Cliente adicionado com sucesso!";
    }

    // get by Id
    @GetMapping("/{id}")
    public String getbyID(@PathVariable UUID Id) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(Id)) {
                return cliente.toString();
            }
        }
        return "Cliente não encontrado.";
    }

    // update
    @PutMapping("/{id}")
    public String updateCliente(@PathVariable UUID id, @RequestBody Cliente updatedCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                cliente.setNome(updatedCliente.getNome());
                return "Cliente atualizado com sucesso!";
            }
        }
        return "Cliente não encontrado";
    }

    // deletar cliente
    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable UUID Id) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(Id)) {
                clientes.remove(cliente);
                return "Cliente deletado com sucesso. ";
            }
        }
        return "Cliente não encontrado.";
    }
}