/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.Repositories;

import org.springframework.data.repository.CrudRepository;
import team9.FootballDB.Speler;
import team9.FootballDB.Stadion;

/**
 *
 * @author User
 */
public interface SpelerRepository extends CrudRepository<Speler,Integer>{
    
}
