/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.FootballDB;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
/**
 *
 * @author User
 */
@Entity
@Table(name = "trainers")
public class Trainer extends Persoon {
    
    
    @Basic
    @Column(name = "trainer_name")
    private String trainerName;
    
    @OneToOne()
    @MapsId
    @JoinColumn(name="club_id")
    private Club club;

    public String getTrainerName() {
        return trainerName;
    }

    public Club getClub() {
        return club;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public void setClub(Club club) {
        this.club = club;
    }
    
}
