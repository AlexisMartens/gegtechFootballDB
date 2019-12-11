/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.FootballDB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import team9.FootballDB.Stadion;
/**
 *
 * @author User
 */

@Entity
@Table(name="club")
public class Club implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="club_id")
    private int id;
    
    @Basic
    @Column(name = "club_name")
    private String naam;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "club", cascade = CascadeType.ALL)
    private Stadion stadion;
    
    @OneToOne(mappedBy = "club")
    private Trainer trainer;
    
    @OneToMany(mappedBy = "club")
    public List<Speler> spelers;

    public List<Speler> getSpelers() {
        return spelers;
    }

    public void setSpelers(List<Speler> spelers) {
        this.spelers = spelers;
    }
    
    public Club(){
        
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNaam(){
        return naam;
    }
    
    public void setNaam(String naam){
        this.naam=naam;
    }
    
    public void setStadion(Stadion stadion){
        this.stadion = stadion;
    }
    
    public Stadion getStadion(){
        return stadion;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    
    
    
}
