/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.FootballDB.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import team9.FootballDB.Entities.Speler;
import team9.FootballDB.Entities.Trainer;

/**
 *
 * @author User
 */
public interface TrainerRepository extends CrudRepository<Trainer,Long>{
    
}
