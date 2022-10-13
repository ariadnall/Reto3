package com.example.demo.repository.crudRepository;

import com.example.demo.model.Messages;
import org.springframework.data.repository.CrudRepository;

public interface MessagesCrudRepository extends CrudRepository<Messages,Integer> {
}
