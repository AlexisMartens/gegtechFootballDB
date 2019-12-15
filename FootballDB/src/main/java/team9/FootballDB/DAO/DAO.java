package team9.FootballDB.DAO;


import team9.FootballDB.Entities.Club;
import team9.FootballDB.Repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import team9.FootballDB.Entities.Competitie;
import team9.FootballDB.Entities.Speler;
import team9.FootballDB.Entities.Stadion;
import team9.FootballDB.Entities.Trainer;
import team9.FootballDB.Repositories.CompetitieRepository;
import team9.FootballDB.Repositories.SpelerRepository;
import team9.FootballDB.Repositories.StadionRepository;
import team9.FootballDB.Repositories.TrainerRepository;
/**
 *
 * @author User
 */
@Service
public class DAO implements IDAO {
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private StadionRepository stadionRepository;
    @Autowired
    private CompetitieRepository competitieRepository;
    @Autowired
    private SpelerRepository spelerRepository;
    @Autowired
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
    public synchronized void addClub(Club club){
        clubRepository.save(club);
    }
    
    @Override
    public List<Club> getAllClubs() {
        List<Club> list = new ArrayList<>();
        clubRepository.findAll().forEach(list::add);
        return list;
    }
    
    @Override
    public Club getClubById(Long clubId){
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
    public void deleteClub(Long clubId){
        clubRepository.delete(getClubById(clubId));
    }
    
    
    // methodes voor Stadion
    @Override
    public synchronized void addStadion(Stadion stadion){
        stadionRepository.save(stadion);
    }
    
    @Override
    public List<Stadion> getAllStadions() {
        List<Stadion> list = new ArrayList<>();
        stadionRepository.findAll().forEach(list::add);
        return list;
    }
    
    @Override
    public Stadion getStadionById(Long stadionId){
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
    public void deleteStadion(Long stadionId){
        stadionRepository.delete(getStadionById(stadionId));
    }
    
    //methodes voor Competitie
    @Override
    public synchronized void addCompetitie(Competitie competitie) {
        competitieRepository.save(competitie);
    }

    @Override
    public List<Competitie> getAllCompetities() {
        List<Competitie> list = new ArrayList<>();
        competitieRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Competitie getCompetitieById(Long competitieId) {
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
    public void deleteCompetitie(Long competitieId) {
        competitieRepository.delete(getCompetitieById(competitieId));
    }
    
    //methodes voor Speler
    @Override
    public synchronized void addSpeler(Speler speler) {
        spelerRepository.save(speler);
    }

    @Override
    public List<Speler> getAllSpelers() {
        List<Speler> list = new ArrayList<>();
        spelerRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Speler getSpelerById(Long spelerId) {
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
    public void deleteSpeler(Long spelerId) {
        spelerRepository.delete(getSpelerById(spelerId));
    }
    
    //methodes voor Trainer
    @Override
    public synchronized void addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        List<Trainer> list = new ArrayList<>();
        trainerRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Trainer getTrainerById(Long trainerId) {
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
    public void deleteTrainer(Long trainerId) {
        trainerRepository.delete(getTrainerById(trainerId));
    }

    @Override
    public void addClubs(List<Club> lijst) {
        for(Club c : lijst){
            addClub(c);
        }
    }

    @Override
    public void addStadions(List<Stadion> lijst) {
        for(Stadion s : lijst){
            addStadion(s);
        }
    }

    @Override
    public void addCompetities(List<Competitie> lijst) {
        for(Competitie c : lijst){
            addCompetitie(c);
        }
    }

    @Override
    public void addSpelers(List<Speler> lijst) {
        for(Speler s: lijst){
            addSpeler(s);
        }
    }

    @Override
    public void addTrainers(List<Trainer> lijst) {
        for(Trainer t: lijst){
            addTrainer(t);
        }
    }
    
    
    //parameter methode

    @Override
    public Set<Club> getClubsByName(String naam) {
        return clubRepository.findAllClubsWithName(naam);
    }
    
 
}