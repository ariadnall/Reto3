package com.example.demo.repository.crudRepository;

import com.example.demo.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client,Integer> {
}
