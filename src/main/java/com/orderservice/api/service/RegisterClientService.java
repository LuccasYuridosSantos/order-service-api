package com.orderservice.api.service;

import com.orderservice.api.exception.BusnessException;
import com.orderservice.api.model.Client;
import com.orderservice.api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client salveClient(Client client){

        Client existingCustomer = clientRepository.findByEmail(client.getEmail());

        if (existingCustomer != null && !existingCustomer.equals(client)){
            throw new BusnessException("Já existe um cliente registrado com este e-mail.");
        }

        return clientRepository.save(client);
    }

    public void deleteClient(Long clientId){
        clientRepository.deleteById(clientId);
    }

}
