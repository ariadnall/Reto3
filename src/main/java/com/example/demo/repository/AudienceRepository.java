package com.example.demo.repository;

import com.example.demo.model.Audience;

import com.example.demo.repository.crudRepository.AudienceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AudienceRepository {
    @Autowired
    private AudienceCrudRepository audienceCrudRepository;

    public List<Audience> getAll(){
        return(List<Audience>) audienceCrudRepository.findAll();
    }
    public Audience save(Audience audience){
        return audienceCrudRepository.save(audience);
    }
    public Optional<Audience> getAudience(int id) {
        return audienceCrudRepository.findById(id);
    }
    public void delete(Audience audience){
        audienceCrudRepository.delete(audience);
    }
}
