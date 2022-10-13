package com.example.demo.service;


import com.example.demo.model.Audience;

import com.example.demo.repository.AudienceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AudienceService {
    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll() {
        return audienceRepository.getAll();
    }
    public Optional <Audience>getAudience(int id ){ return audienceRepository.getAudience(id);}
    public Audience save(Audience audience){
        if (audience.getId()==null){
            return audienceRepository.save(audience);
        } else {
            Optional<Audience> opt = audienceRepository.getAudience(audience.getId());
            if (opt.isEmpty()){
                return audienceRepository.save(audience);
            }else {
                return audience;
            }
        }
    }
    public Audience update(Audience audience){
        if (audience.getId()!= null){
            Optional<Audience> opt1 = audienceRepository.getAudience((audience.getId()));
            if (opt1.isPresent()){
                if (audience.getOwner() != null){
                    opt1.get().setOwner(audience.getOwner());
                }
                if(audience.getName() != null){
                    opt1.get().setName(audience.getName());
                }
                if (audience.getCapacity() != null) {
                    opt1.get().setCapacity(audience.getCapacity());
                }
                if (audience.getDescription() != null) {
                    opt1.get().setDescription(audience.getDescription());
                }
                audienceRepository.save(opt1.get());
                return opt1.get();
                }else {
                    return audience;
                }
            } else {
            return audience;

        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Audience>audience = audienceRepository.getAudience(id);
        if (audience.isPresent()){
            audienceRepository.delete(audience.get());
            flag=true;
        }
        return flag;
    }
}
