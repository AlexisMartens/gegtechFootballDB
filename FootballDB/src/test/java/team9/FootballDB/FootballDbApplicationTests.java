package team9.FootballDB;

import team9.FootballDB.Entities.Club;
import team9.FootballDB.Entities.Speler;
import team9.FootballDB.Repositories.SpelerRepository;
import team9.FootballDB.Repositories.StadionRepository;
import team9.FootballDB.Repositories.TrainerRepository;
import team9.FootballDB.Repositories.CompetitieRepository;
import team9.FootballDB.Repositories.ClubRepository;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team9.FootballDB.DAO.DAO;
import team9.FootballDB.DAO.IDAO;
import team9.FootballDB.Entities.Adres;
import team9.FootballDB.Entities.Stadion;


@SpringBootTest
class FootballDbApplicationTests {
  
    @Autowired
    private IDAO dao;

    Factory f = new Factory();

    @Test
    void TestAddingClub() {
        Club club = f.createClub("Ajax");
        int voor = dao.getAllClubs().size();
        dao.addClub(club);
        int na = dao.getAllClubs().size();
        Assert.assertEquals("toegevoegd", voor+1, na);
        
        
    }
    
    @Test
    void testGettingClub(){
        Club club = f.createClub("Beveren");
        dao.addClub(club);
        Club c = dao.getClubById(club.getId());
        Assert.assertTrue("opgehaalde club is gelijk", club.equals(c));
    }
    
    @Test
    void testAddingSpeler(){
        Club club = f.createClub("Cercle");
        Speler speler = f.createSpeler("Hazard");
        speler.setClub(club);
        List<Speler> spelers = new ArrayList<>();
        spelers.add(speler);
        club.setSpelers(spelers);
        int voor = dao.getAllSpelers().size();
        dao.addClub(club);
        dao.addSpeler(speler);
        int na = dao.getAllSpelers().size();
        Assert.assertEquals("toegevoegd", voor+1, na);
        
    }
    
    @Test
    void testLazyFetching(){
        Club club = f.createClub("Club Brugge");
        Speler speler = f.createSpeler("Hans Vanaken");
        speler.setClub(club);
        List<Speler> spelers = new ArrayList<>();
        spelers.add(speler);
        club.setSpelers(spelers);
        dao.addClub(club);
        dao.addSpeler(speler);
        Club c = dao.getClubById(club.getId());
        List<Speler> lijst = c.getSpelers();
        if(lijst == null){
            System.out.println("is null");
        }
        Assert.assertTrue("lazy fetching", !Hibernate.isInitialized(c.getSpelers()));  
    }
    
    @Test
    void testNotLazyFetching(){
        Club club = f.createClub("Cercle Brugge");
        Stadion stadion = f.createStadion("Jan Breyde");
        stadion.setClub(club);
        dao.addClub(club);
        dao.addStadion(stadion);
        Club c = dao.getClubById(club.getId());
        Assert.assertTrue("lazy fetching", !Hibernate.isInitialized(c.getStadion()));
    }
    
    @Test
    void testValueObject(){
        Stadion stadion = f.createStadion("Jan Breyde");
        Adres adres = f.createAdres("Straat","4",9000,"Brugge");
        stadion.setAdres(adres);
        dao.addStadion(stadion);
        //Hoe kunnen we da nu testen??        
    }
    
    @Test
    void testUpdateClub(){
        Club club = f.createClub("Cercle");
        dao.addClub(club);
        Club c = dao.getClubById(club.getId());
        c.setNaam("Ajax");
        dao.updateClub(c);
        Assert.assertEquals("Update club", "Ajax", c.getNaam());
    }
    
    @Test
    void testVerwijderClub(){
        Club club = f.createClub("Cercle");
        Club club2 = f.createClub("Ajax");
        dao.addClub(club);
        dao.addClub(club2);
        dao.deleteClub(club.getId());
        int aantal = dao.getAllClubs().size();
        Assert.assertEquals("toegevoegd", 1, aantal);
    }
}
