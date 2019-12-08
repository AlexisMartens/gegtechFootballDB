/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.DAO;

import java.util.List;
import team9.FootballDB.Club;

/**
 *
 * @author alex-
 */
public interface IDAO {
    boolean addClub(Club c);
    
    List<Club> getAllClubs();
    Club getClubById(Integer clubId);
    
    void UpdateClub(Club club);
    
    void deleteClub(Integer clubID);
    
}
