/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.FootballDB;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team9.FootballDB.DAO.IDAO;
import team9.FootballDB.Entities.Club;
import team9.FootballDB.Entities.Competitie;
import team9.FootballDB.Entities.Speler;
import team9.FootballDB.Entities.Stadion;
import team9.FootballDB.Entities.Trainer;

/**
 *
 * @author User
 */
public class Factory {
   
    private String namenClubs[] = {"Ajax","Cercle","Standard","Feynoord"};
    private String namenSpelers[] = {"Ronaldo","Messi","Neymar","Hazard"};
    
    private Club createClub(String naam) {
        Club club = new Club();
        club.setNaam(naam);
        return club;
    }

    private Speler createSpeler(String naam) {
        Speler speler = new Speler();
        speler.setSpelerName(naam);
        return speler;
    }
    
    private Competitie createCompetitie(String naam){
        Competitie competitie = new Competitie();
        competitie.setCompetitieName(naam);
        return competitie;
    }
    
    private Stadion createStadion(String naam){
        Stadion stadion = new Stadion();
        stadion.setStadionName(naam);
        return stadion;
    }
    
    private Trainer createTrainer(String naam){
        Trainer trainer = new Trainer();
        trainer.setTrainerName(naam);
        return trainer;
    }
    
    List<Club> maakClubs(){
        List<Club> lijst = new ArrayList<>();
        for(String naam: namenClubs){
            lijst.add(createClub(naam));
        }
        return lijst;
    }
    
    List<Speler> maakSpelers(){
        List<Speler> lijst = new ArrayList<>();
        for(String naam: namenSpelers){
            lijst.add(createSpeler(naam));
        }
        return lijst;
    }
    
}
