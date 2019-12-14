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

}
