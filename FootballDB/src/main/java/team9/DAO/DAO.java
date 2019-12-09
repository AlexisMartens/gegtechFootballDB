package team9.DAO;


import team9.FootballDB.Club;
import team9.Repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import team9.FootballDB.Stadion;
import team9.Repositories.StadionRepository;
/**
 *
 * @author User
 */
@Service
public class DAO implements IDAO {
    @Autowired
    private ClubRepository clubRepository;
    private StadionRepository stadionRepository;
    
    
    public DAO(ClubRepository clubRepository, StadionRepository stadionRepository){
        this.clubRepository = clubRepository;
        this.stadionRepository = stadionRepository;
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
}