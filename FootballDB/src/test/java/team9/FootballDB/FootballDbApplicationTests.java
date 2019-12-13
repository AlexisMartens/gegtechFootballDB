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

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class FootballDbApplicationTests {

    @Mock
    ClubRepository cr;
    @Mock
    CompetitieRepository compr;
    @Mock
    SpelerRepository sr;
    @Mock
    StadionRepository str;
    @Mock
    TrainerRepository tr;
    
    @InjectMocks
    private DAO dao;

    @Test
    void contextLoads() {
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private Club createClub(String naam) {
        Club club = new Club();
        club.setNaam(naam);
        return club;
    }

    private Speler createSpeler(String naam) {
        Speler speler = new Speler();
        speler.setSpelerName(naam);
        return speler;
    }

    @Test
    void TestAddingClub() {
        //IDAO dao = new DAO() --> hebben repositories nodig...
        Club club = createClub("Ajax");
        //Speler speler = createSpeler("Tadic");
        //speler.setClub(club);
        //List<Speler> spelers = new ArrayList<>();
        //spelers.add(speler);
        //club.setSpelers(spelers);

        dao.addClub(club);
        //ao.addSpeler(speler);
    }

}
