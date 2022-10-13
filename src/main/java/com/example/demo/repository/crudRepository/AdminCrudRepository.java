package com.example.demo.repository.crudRepository;

import com.example.demo.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<Admin,Integer> {
}
