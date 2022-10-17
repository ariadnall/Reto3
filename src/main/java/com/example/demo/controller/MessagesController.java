package com.example.demo.controller;

import com.example.demo.model.Messages;
import com.example.demo.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin (origins ="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api/Message")
public class MessagesController {
    @Autowired
    private MessagesService messagesService;
    @GetMapping("/all")
    public List<Messages>getMessage(){
        return messagesService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Messages> getMessage(@PathVariable("id") int id){
        return messagesService.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Messages messages) {
        messagesService.save(messages);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages update(@RequestBody Messages messages){
        return messagesService.update(messages);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return messagesService.delete(id);
    }


}
