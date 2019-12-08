/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.DAO;


import team9.FootballDB.Club;
import team9.Repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class DAO implements IDAO {
    @Autowired
    private ClubRepository clubRepository;
    
    @Override
    public synchronized boolean addClub(Club club){
        clubRepository.save(club);
        return false;
    }
    
    /**
     *
     * @return
     */
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
}
