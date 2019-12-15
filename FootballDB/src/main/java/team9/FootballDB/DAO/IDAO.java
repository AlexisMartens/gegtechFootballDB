/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.FootballDB.DAO;

import java.util.List;
import team9.FootballDB.Entities.Club;
import team9.FootballDB.Entities.Competitie;
import team9.FootballDB.Entities.Speler;
import team9.FootballDB.Entities.Stadion;
import team9.FootballDB.Entities.Trainer;

/**
 *
 * @author alex-
 */
public interface IDAO {
    
    void addClub(Club c);
    List<Club> getAllClubs();
    Club getClubById(Long clubId);
    void updateClub(Club club);
    void deleteClub(Long clubID);
    void addClubs(List<Club> c);
    
    void addStadion(Stadion stadion);
    List<Stadion> getAllStadions();
    Stadion getStadionById(Long stadionId);
    void updateStadion(Stadion stadion);
    void deleteStadion(Long stadionId);
    void addStadions(List<Stadion> stadion);
    
    void addCompetitie(Competitie competitie);
    List<Competitie> getAllCompetities();
    Competitie getCompetitieById(Long competitieId);
    void updateCompetitie(Competitie competitie);
    void deleteCompetitie(Long competitieId);
    void addCompetities(List<Competitie> competitie);
    
    void addSpeler(Speler speler);
    List<Speler> getAllSpelers();
    Speler getSpelerById(Long spelerId);
    void updateSpeler(Speler speler);
    void deleteSpeler(Long spelerId);
    void addSpelers(List<Speler> speler);
    
    void addTrainer(Trainer trainer);
    List<Trainer> getAllTrainers();
    Trainer getTrainerById(Long trainerId);
    void updateTrainer(Trainer trainer);
    void deleteTrainer(Long trainerId);
    void addTrainers(List<Trainer> trainer);
    
}
