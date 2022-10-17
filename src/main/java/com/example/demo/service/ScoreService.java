package com.example.demo.service;

import com.example.demo.model.Score;
import com.example.demo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional <Score>getScore(int id ){ return scoreRepository.getScore(id);}


    public Score save(Score score){
        if(score.getIdScore() == null){
            return scoreRepository.save(score);
        }
        else{
            Optional<Score> opt = scoreRepository.getScore(score.getIdScore());
            if(opt.isEmpty()){
                return scoreRepository.save(score);
            }else{
                return score;
            }
        }
    }
    public Score update (Score score){
        if (score.getIdScore()!=null){
            Optional<Score> q = scoreRepository.getScore(score.getIdScore());
            if (!q.isEmpty()){
                if(score.getMessageText()!=null){
                    q.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){
                    q.get().setStars(score.getStars());
                }
                scoreRepository.save(q.get());
                return q.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }
    public boolean delete(int id){
        Boolean respuesta = getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
