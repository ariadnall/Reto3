package com.example.demo.service;
 import com.example.demo.model.Client;
 import com.example.demo.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional <Client>getClient(int id ){ return clientRepository.getClient(id);}


    public Client save(Client client){
        if(client.getIdClient() == null){
            return clientRepository.save(client);
        }
        else{
            Optional<Client> opt = clientRepository.getClient(client.getIdClient());
            if(opt.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
    public Client update (Client client){
        if (client.getIdClient()!=null){
            Optional<Client> opt1 = clientRepository.getClient(client.getIdClient());
            if (!opt1.isEmpty()){
                if(client.getEmail()!=null){
                    opt1.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    opt1.get().setPassword(client.getPassword());
                }
                if(client.getName()!=null){
                    opt1.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    opt1.get().setAge(client.getAge());
                }


                clientRepository.save(opt1.get());
                return opt1.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    public boolean delete(int id){
        Boolean respuesta = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
