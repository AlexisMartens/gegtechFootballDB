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
@Table(name = "trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trainer_id")
    private Integer trainerID;
    
    @Basic
    @Column(name = "trainer_name")
    private String trainerName;
    
    @OneToOne(targetEntity = Club.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Club club;

    public Integer getTrainerID() {
        return trainerID;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public Club getClub() {
        return club;
    }

    public void setTrainerID(Integer trainerID) {
        this.trainerID = trainerID;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public void setClub(Club club) {
        this.club = club;
    }
    
}
