package com.example.demo.service;
import com.example.demo.model.CountClient;
import com.example.demo.model.Reservation;
import com.example.demo.model.StatusAccount;
import com.example.demo.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional <Reservation>getReservation(int id ){ return reservationRepository.getReservation(id);}


    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        }
        else{
            Optional<Reservation> opt = reservationRepository.getReservation(reservation.getIdReservation());
            if(opt.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    public Reservation update (Reservation reservation){
        if (reservation.getIdReservation()!=null){
            Optional<Reservation> q = reservationRepository.getReservation(reservation.getIdReservation());
            if (!q.isEmpty()){
                if(reservation.getStartDate()!=null){
                    q.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    q.get().setStatus(reservation.getStatus());
                }

                reservationRepository.save(q.get());
                return q.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    public boolean delete(int id){
        Boolean respuesta = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return respuesta;
    }
    public List<Reservation> getReservationByDates(String dateOne, String dateTwo){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a= new Date();
        Date b= new Date();
        try{
            a = parser.parse(dateOne);
            b = parser.parse(dateTwo);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (a.before(b)){
            return reservationRepository.getDatesReport(a, b);
        }else {
            return new ArrayList<>();
        }
    }
    public StatusAccount getReportByStatus() {
        List<Reservation> completed = reservationRepository.getStatusReport("completed");
        List<Reservation> cancelled = reservationRepository.getStatusReport("cancelled");

        return new StatusAccount(completed.size(), cancelled.size());
    }
    public List<CountClient> countTotalReservationsByClient(){
        return reservationRepository.countTotalReservationsByClient();
    }


}
