/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.FootballDB;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
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
    private int id;
    private String naam;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadion_id")
    private Stadion stadion;
    
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
    
}
