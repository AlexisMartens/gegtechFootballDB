/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.FootballDB.Repositories;

import java.util.Collection;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import team9.FootballDB.Entities.Club;

/**
 *
 * @author alex-
 */
public interface ClubRepository extends CrudRepository<Club,Long>{
    
    @Query(value = "select * from club c where c.club_name = :naam", nativeQuery = true)
    Set<Club> findAllClubsWithName(@Param("naam")String naam);
    
}
