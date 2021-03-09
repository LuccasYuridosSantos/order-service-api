package com.orderservice.api.controller;

import com.orderservice.api.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/listar")
public class ClientController {

    @GetMapping
    public List<Client> list(){
        List<Client> listClient = new ArrayList<>();
        listClient.add(new Client(1L, "Luccas","Ly@email.com","(19)999999999"));
        listClient.add(new Client(2L, "Yuri","Yu@email.com","(19)999999998"));
        listClient.add(new Client(3L, "Juliana","Ju@email.com","(19)999999979"));
        listClient.add(new Client(4L, "Antônio","Ant@email.com","(19)999999996"));
        listClient.add(new Client(5L, "Robson","Robson@email.com","(19)999999967"));

        return listClient;
    }
}
