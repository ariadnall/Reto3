package com.example.demo.repository;

import com.example.demo.model.Client;
import com.example.demo.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
}
