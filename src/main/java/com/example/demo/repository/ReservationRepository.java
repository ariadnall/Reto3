package com.example.demo.repository;


import com.example.demo.model.Reservation;

import com.example.demo.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public Optional<Reservation> getClient(int id){
        return reservationCrudRepository.findById(id);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }
}
