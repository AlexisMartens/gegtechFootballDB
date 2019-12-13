/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.FootballDB;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 *
 * @author User
 */
@Entity
@Table(name="stadion")
public class Stadion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stadionID;
    //1 Op 1 relatie
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name="club_id")
    private Club club;
    
    @Embedded
    private Adres adres;

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
    
    
    @Basic
    @Column(name= "stadion_name")
    private String stadionName;
    
    @Basic
    @Column(name= "stadion_capaciteit")
    private Integer stadion_capaciteit;

    public Stadion(){
        
    }

    public Integer getStadionID() {
        return stadionID;
    }

    public Club getClub() {
        return club;
    }

    public String getStadionName() {
        return stadionName;
    }

    public Integer getStadion_capaciteit() {
        return stadion_capaciteit;
    }

    public void setStadionID(Integer stadionID) {
        this.stadionID = stadionID;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public void setStadionName(String stadionName) {
        this.stadionName = stadionName;
    }

    public void setStadion_capaciteit(Integer stadion_capaciteit) {
        this.stadion_capaciteit = stadion_capaciteit;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.stadionID);
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
        final Stadion other = (Stadion) obj;
        if (!Objects.equals(this.stadionID, other.stadionID)) {
            return false;
        }
        return true;
    }
    
    
    
}
