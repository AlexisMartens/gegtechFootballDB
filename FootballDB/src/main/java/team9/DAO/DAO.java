package team9.DAO;


import team9.FootballDB.Club;
import team9.Repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import team9.FootballDB.Competitie;
import team9.FootballDB.Speler;
import team9.FootballDB.Stadion;
import team9.FootballDB.Trainer;
import team9.Repositories.CompetitieRepository;
import team9.Repositories.SpelerRepository;
import team9.Repositories.StadionRepository;
import team9.Repositories.TrainerRepository;
/**
 *
 * @author User
 */
@Service
public class DAO implements IDAO {
    @Autowired
    private ClubRepository clubRepository;
    private StadionRepository stadionRepository;
    private CompetitieRepository competitieRepository;
    private SpelerRepository spelerRepository;
    private TrainerRepository trainerRepository;
    
    
    public DAO(ClubRepository clubRepository, StadionRepository stadionRepository, CompetitieRepository competitieRepository, SpelerRepository spelerRepository, TrainerRepository trainerRepository){
        this.clubRepository = clubRepository;
        this.stadionRepository = stadionRepository;
        this.competitieRepository = competitieRepository;
        this.spelerRepository = spelerRepository;
        this.trainerRepository = trainerRepository;
    }
    
    
    //Methodes voor ClubRepostiroy
    @Override
    public synchronized boolean addClub(Club club){
        clubRepository.save(club);
        return false;
    }
    
    @Override
    public List<Club> getAllClubs() {
        List<Club> list = new ArrayList<>();
        clubRepository.findAll().forEach(list::add);
        return list;
    }
    
    @Override
    public Club getClubById(Integer clubId){
        if(clubRepository.findById(clubId).isPresent()){
            return clubRepository.findById(clubId).get();
        }
        else {
            return null;
        }
    }
    
    @Override
    public void updateClub(Club club){
        clubRepository.save(club);
    }
    
    @Override
    public void deleteClub(Integer clubId){
        clubRepository.delete(getClubById(clubId));
    }
    
    
    // methodes voor Stadion
    @Override
    public synchronized boolean addStadion(Stadion stadion){
        stadionRepository.save(stadion);
        return false;
    }
    
    @Override
    public List<Stadion> getAllStadions() {
        List<Stadion> list = new ArrayList<>();
        stadionRepository.findAll().forEach(list::add);
        return list;
    }
    
    @Override
    public Stadion getStadionById(Integer stadionId){
        if(stadionRepository.findById(stadionId).isPresent()){
            return stadionRepository.findById(stadionId).get();
        }
        else {
            return null;
        }
    }
    
    @Override
    public void updateStadion(Stadion stadion){
        stadionRepository.save(stadion);
    }
    
    @Override
    public void deleteStadion(Integer stadionId){
        stadionRepository.delete(getStadionById(stadionId));
    }
    
    //methodes voor Competitie
    @Override
    public synchronized boolean addCompetitie(Competitie competitie) {
        competitieRepository.save(competitie);
        return false;
    }

    @Override
    public List<Competitie> getAllCompetities() {
        List<Competitie> list = new ArrayList<>();
        competitieRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Competitie getCompetitieById(Integer competitieId) {
        if(competitieRepository.findById(competitieId).isPresent()){
            return competitieRepository.findById(competitieId).get();
        }
        else{
            return null;
        }
    }

    @Override
    public void updateCompetitie(Competitie competitie) {
        competitieRepository.save(competitie);
    }

    @Override
    public void deleteCompetitie(Integer competitieId) {
        competitieRepository.delete(getCompetitieById(competitieId));
    }
    
    //methodes voor Speler
    @Override
    public synchronized boolean addSpeler(Speler speler) {
        spelerRepository.save(speler);
        return false;
    }

    @Override
    public List<Speler> getAllSpelers() {
        List<Speler> list = new ArrayList<>();
        spelerRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Speler getSpelerById(Integer spelerId) {
        if(spelerRepository.findById(spelerId).isPresent()){
            return spelerRepository.findById(spelerId).get();
        }
        else{
            return null;
        }
    }

    @Override
    public void updateSpeler(Speler speler) {
        spelerRepository.save(speler);
    }

    @Override
    public void deleteSpeler(Integer spelerId) {
        spelerRepository.delete(getSpelerById(spelerId));
    }
    
    //methodes voor Trainer
    @Override
    public synchronized boolean addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
        return false;
    }

    @Override
    public List<Trainer> getAllTrainers() {
        List<Trainer> list = new ArrayList<>();
        trainerRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Trainer getTrainerById(Integer trainerId) {
        if(trainerRepository.findById(trainerId).isPresent()){
            return trainerRepository.findById(trainerId).get();
        }
        else{
            return null;
        }
    }

    @Override
    public void updateTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }

    @Override
    public void deleteTrainer(Integer trainerId) {
        trainerRepository.delete(getTrainerById(trainerId));
    }

}