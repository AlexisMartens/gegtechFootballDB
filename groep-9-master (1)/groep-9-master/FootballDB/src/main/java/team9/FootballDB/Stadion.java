/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team9.FootballDB;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 *
 * @author User
 */
@Embeddable
@Table(name="stadion")
public class Stadion implements Serializable {
    @Id
    @OneToOne(mappedBy = "club",
              fetch = FetchType.LAZY)
    private Club club;
}
