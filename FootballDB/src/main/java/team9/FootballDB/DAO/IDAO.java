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
    
    boolean addClub(Club c);
    List<Club> getAllClubs();
    Club getClubById(Integer clubId);
    void updateClub(Club club);
    void deleteClub(Integer clubID);
    
    boolean addStadion(Stadion stadion);
    List<Stadion> getAllStadions();
    Stadion getStadionById(Integer stadionId);
    void updateStadion(Stadion stadion);
    void deleteStadion(Integer stadionId);
    
    boolean addCompetitie(Competitie competitie);
    List<Competitie> getAllCompetities();
    Competitie getCompetitieById(Integer competitieId);
    void updateCompetitie(Competitie competitie);
    void deleteCompetitie(Integer competitieId);
    
    boolean addSpeler(Speler speler);
    List<Speler> getAllSpelers();
    Speler getSpelerById(Integer spelerId);
    void updateSpeler(Speler speler);
    void deleteSpeler(Integer spelerId);
    
    boolean addTrainer(Trainer trainer);
    List<Trainer> getAllTrainers();
    Trainer getTrainerById(Integer trainerId);
    void updateTrainer(Trainer trainer);
    void deleteTrainer(Integer trainerId);
    
}
