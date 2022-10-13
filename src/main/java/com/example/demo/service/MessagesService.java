package com.example.demo.service;
import com.example.demo.model.Messages;
import com.example.demo.repository.MessagesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessagesService {
    @Autowired
    private MessagesRepository messageRepository;

    public List<Messages> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Messages>getMessage(int id){
        return  messageRepository.getMessage(id);
    }
    public Messages save(Messages message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Messages> e = messageRepository.getMessage(message.getIdMessage());
            if(e.isPresent()){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }
    }
    public Messages update (Messages messages){
        if (messages.getIdMessage()!=null){
            Optional<Messages> q = messageRepository.getMessage(messages.getIdMessage());
            if (q.isPresent()){
                if(messages.getMessageText()!=null){
                    q.get().setMessageText(messages.getMessageText());
                }
                messageRepository.save(q.get());
                return q.get();
            }else{
                return messages;
            }
        }else{
            return messages;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Messages>message=messageRepository.getMessage(id);
        if(message.isPresent()){
            messageRepository.delete(message.get());
            flag=true;
        }
        return flag;
    }

}
