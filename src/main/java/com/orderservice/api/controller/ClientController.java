package com.orderservice.api.controller;

import com.orderservice.api.model.Client;
import com.orderservice.api.repository.ClientRepository;
import com.orderservice.api.service.RegisterClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private RegisterClientService clientService;

    @GetMapping("/listar")
    public List<Client> list(){
        return repository.findAll();
    }

    @GetMapping("/nome/{name}")
    public List<Client> findByName(@PathVariable String name){
        return repository.findByNameIgnoreCase(name);
    }

    @GetMapping("/nomes/{name}")
    public List<Client> findByNameContaining(@PathVariable String name){
        return repository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        Optional<Client> client = repository.findById(id);

        if (client.isPresent()){
            return ResponseEntity.ok(client.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client addClient(@Valid @RequestBody Client client){
        return clientService.salveClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@Valid @PathVariable long id, @RequestBody Client client){
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        client.setId(id);
        return ResponseEntity.ok(clientService.salveClient(client));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        clientService.deleteClient(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
