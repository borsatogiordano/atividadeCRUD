package com.api.viacep.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.viacep.classes.Cliente;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    // Simulação de um banco de dados em memória
    private static List<Cliente> clientes = new ArrayList<>();

    // Get all clients
    @GetMapping
    public String getAllClientes() {
        if (!clientes.isEmpty()) {
            // Usar o Gson para retornar os objetos
            return clientes.toString();
        } else {
            return "Não há clientes cadastrados.";
        }
    }

    @PostMapping
    public String addCliente(@RequestBody Cliente cliente) {
        System.out.println("Adicionando cliente...");
        clientes.add(cliente);
        return "Cliente adicionado com sucesso!";
    }
}

