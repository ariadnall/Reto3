package com.example.demo.repository;


import com.example.demo.model.Messages;
import com.example.demo.repository.crudRepository.MessagesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessagesRepository {
    @Autowired
    private MessagesCrudRepository messagesCrudRepository;

    public List<Messages> getAll(){
        return (List<Messages>) messagesCrudRepository.findAll();
    }
    public Optional<Messages> getMessage(int id) {
        return messagesCrudRepository.findById(id);
    }
    public Messages save(Messages messages){
        return messagesCrudRepository.save(messages);
    }

    public void delete(Messages messages){
        messagesCrudRepository.delete(messages);
    }


}
