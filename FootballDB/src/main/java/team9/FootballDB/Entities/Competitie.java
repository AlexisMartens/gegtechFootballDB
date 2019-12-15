/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.FootballDB.Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    private Long competitieID;
    
    @ManyToMany(mappedBy = "competities", cascade = CascadeType.ALL)
    private List<Club> clubs;
    
    @Basic
    @Column(name = "competitie_name")
    private String competitieName;
    
    @Basic
    @Column(name = "competitie_aantal")
    private Integer aantalTeams;

    public Long getCompetitieID() {
        return competitieID;
    }

    public String getCompetitieName() {
        return competitieName;
    }

    public Integer getAantalTeams() {
        return aantalTeams;
    }

    public void setCompetitieID(Long competitieID) {
        this.competitieID = competitieID;
    }

    public void setCompetitieName(String competitieName) {
        this.competitieName = competitieName;
    }

    public void setAantalTeams(Integer aantalTeams) {
        this.aantalTeams = aantalTeams;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.competitieID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Competitie other = (Competitie) obj;
        if (!Objects.equals(this.competitieID, other.competitieID)) {
            return false;
        }
        return true;
    }
    
    
}
