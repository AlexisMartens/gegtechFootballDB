/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.FootballDB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    private Integer stadionID;
    //1 Op 1 relatie
    @OneToOne()
    @MapsId
    @JoinColumn(name="stadion_id??")
    private Club club;
    
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
    
    
}
