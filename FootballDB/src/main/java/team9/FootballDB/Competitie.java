/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.FootballDB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name="competitie")
public class Competitie implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="competitie_id")
    private Integer competitieID;
    
    @Basic
    @Column(name = "competitie_name")
    private String competitieName;
    
    @Basic
    @Column(name = "competitie_aantal")
    private Integer aantalTeams;

    public Integer getCompetitieID() {
        return competitieID;
    }

    public String getCompetitieName() {
        return competitieName;
    }

    public Integer getAantalTeams() {
        return aantalTeams;
    }

    public void setCompetitieID(Integer competitieID) {
        this.competitieID = competitieID;
    }

    public void setCompetitieName(String competitieName) {
        this.competitieName = competitieName;
    }

    public void setAantalTeams(Integer aantalTeams) {
        this.aantalTeams = aantalTeams;
    }
    
    
}