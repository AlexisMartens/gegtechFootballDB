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
@Table(name = "spelers")
public class Speler {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "speler_id")
    private Integer spelerID;
    
    @Basic
    @Column(name = "speler_name")
    private String spelerName;
    
    // school is een Foreign-Key van tabel 'spelers' en verwijst naar een 'club'
    @ManyToOne(targetEntity = Club.class)
    @JoinColumn(name = "club_fk_speler", nullable = false)
    private Club club;

    public Integer getSpelerID() {
        return spelerID;
    }

    public String getSpelerName() {
        return spelerName;
    }

    public Club getClub() {
        return club;
    }

    public void setSpelerID(Integer spelerID) {
        this.spelerID = spelerID;
    }

    public void setSpelerName(String spelerName) {
        this.spelerName = spelerName;
    }

    public void setClub(Club club) {
        this.club = club;
    }
    
}