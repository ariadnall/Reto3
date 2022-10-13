package com.example.demo.repository.crudRepository;

import com.example.demo.model.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score,Integer> {
}
