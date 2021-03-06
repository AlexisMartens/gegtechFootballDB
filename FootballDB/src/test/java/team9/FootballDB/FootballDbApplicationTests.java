package team9.FootballDB;

import team9.FootballDB.Entities.Club;
import team9.FootballDB.Entities.Speler;
import team9.FootballDB.Repositories.SpelerRepository;
import team9.FootballDB.Repositories.StadionRepository;
import team9.FootballDB.Repositories.TrainerRepository;
import team9.FootballDB.Repositories.CompetitieRepository;
import team9.FootballDB.Repositories.ClubRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import team9.FootballDB.Entities.Competitie;
import team9.FootballDB.Entities.Stadion;
import team9.FootballDB.Entities.Trainer;


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
        Assert.assertEquals("toegevoegd 1-n relatie", voor+1, na);
        
    }
    
    @Test
    void testAddingSpelerNoCascade(){
        Club club = f.createClub("Cercle");
        Speler speler = f.createSpeler("Hazard");
        speler.setClub(club);
        List<Speler> spelers = new ArrayList<>();
        spelers.add(speler);
        club.setSpelers(spelers);
        int voor = dao.getAllSpelers().size();
        dao.addClub(club);
        //dao.addSpeler(speler); //speler niet toevoegen -> geen cascade dus wordt niet toegevoegd
        int na = dao.getAllSpelers().size();
        Assert.assertEquals("toegevoegd", voor, na); //geen cascade dus speler niet toegevoegd
        
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
        Club club = f.createClub("Ajax");
        Stadion stadion = f.createStadion("Johan Cruyff Stadion");
        stadion.setClub(club);
        club.setStadion(stadion);
        dao.addClub(club);
        dao.addStadion(stadion);
        Club c = dao.getClubById(club.getId());
        Assert.assertTrue("lazy fetching", Hibernate.isInitialized(c.getStadion()));
    }
    
    @Test
    void testValueObject(){
        Stadion stadion = f.createStadion("Jan Breyde");
        Adres adres = f.createAdres("Straat","4",9000,"Brugge");
        stadion.setAdres(adres);
        Club c = f.createClub("Cercle");
        stadion.setClub(c);
        c.setStadion(stadion);
        dao.addStadion(stadion);
        dao.addClub(c);
        Stadion st = dao.getStadionById(stadion.getStadionID());
        Adres a = st.getAdres();
        Assert.assertTrue("adressen zijn gelijk", a.equals(adres));
    }
    
    @Test
    void testUpdateClub(){
        Club club = f.createClub("Cercle");
        dao.addClub(club);
        Club c = dao.getClubById(club.getId());
        c.setNaam("Ajax");
        dao.updateClub(c);
        Club test = dao.getClubById(c.getId());
        Assert.assertEquals("Update club", "Ajax", test.getNaam());
    }
    
    @Test
    void testVerwijderClub(){
        Club club = f.createClub("Cercle");
        Club club2 = f.createClub("Ajax");
        dao.addClub(club);
        dao.addClub(club2);
        int voor = dao.getAllClubs().size();
        dao.deleteClub(club.getId());
        int aantal = dao.getAllClubs().size();
        Assert.assertEquals("toegevoegd", voor-1, aantal);
    }
    
    @Test
    void testCascade(){
        Club club = f.createClub("Cercle");
        Stadion stadion = f.createStadion("Lotto");
        club.setStadion(stadion);
        stadion.setClub(club);
        int voor = dao.getAllStadions().size();
        dao.addClub(club);
        int tussen = dao.getAllStadions().size();
        dao.deleteClub(club.getId());
        int na = dao.getAllStadions().size();
        Assert.assertEquals("Cascade",voor, na);
        Assert.assertEquals("Cascade",tussen-1, na);
    }
    
    @Test
    void testAddingList(){
        List<Speler> lijst = f.maakSpelers();
        Club c = f.createClub("Real Madrid");
        for(Speler s : lijst){
            s.setClub(c);
        }
        c.setSpelers(lijst);
        int voor = dao.getAllSpelers().size();
        dao.addClub(c);
        dao.addSpelers(lijst);
        int na = dao.getAllSpelers().size();
        Assert.assertEquals("Meerdere spelers toegevoegd",voor+lijst.size(), na);
    }
    
    
    @Test
    void testCascade2(){
        Club club = f.createClub("Zulte");
        Trainer trainer = f.createTrainer("Pico Coppens");
        club.setTrainer(trainer);
        trainer.setClub(club);
        int voor = dao.getAllTrainers().size();
        dao.addClub(club);
        //dao.addTrainer(trainer);
        int na = dao.getAllTrainers().size();
        Assert.assertEquals("Cascade",voor+1, na);
    }
    
    
    @Test
    public void testUpdateClubToCompetite(){
        Club club = f.createClub("Eupen");
        Competitie competitie = f.createCompetitie("ESDL");
        List<Competitie> competities = new ArrayList<>();
        //Set<Club> clubs = new HashSet<>();
        //clubs.add(club);
        competities.add(competitie);
        //competitie.setClubs(clubs);
        club.setCompetities(competities);
        dao.addClub(club);
        dao.addCompetitie(competitie);
        Competitie c = dao.getCompetitieById(competitie.getCompetitieID());
        Club club2 = f.createClub("Moeskroen");
        List<Club> clubs2 = c.getClubs();
        clubs2.add(club2);
        dao.updateCompetitie(c);
        int na = clubs2.size();
        Assert.assertEquals("Cascade",2, na);
    }
    
    @Test
    public void testUpdateExtraCompetitie(){
        Club club = f.createClub("Eupen");
        Competitie competitie = f.createCompetitie("JPL");
        List<Competitie> comps = new ArrayList<>();
        comps.add(competitie);
        club.setCompetities(comps);
        dao.addClub(club);
        //dao.addCompetitie(competitie); //cascade
        Club c = dao.getClubById(club.getId());
        Competitie comp2 = f.createCompetitie("Beker");
        List<Competitie> comps2 = c.getCompetities();
        comps2.add(comp2);
        dao.updateClub(c);
        int aantalcomp = dao.getClubById(c.getId()).getCompetities().size();
        Assert.assertEquals("Cascade",2, aantalcomp);
    }
    
    @Test
    void testParameterMethode(){
        Club c = f.createClub("Chelsea");
        dao.addClub(c);
        Set<Club> set = dao.getClubsByName("Chelsea");
        Assert.assertEquals("parameter query gelukt", 1 , set.size());
    }
    
    @Test
    void testAlles(){
        Club az = f.createClub("AZ");
        List<Competitie> s = f.maakCompetities();
        List<Club> set = new ArrayList<>();
        set.add(az);
        for(Competitie comp: s){
            comp.setClubs(set);
        }
        az.setCompetities(s);
        
        Trainer t = f.createTrainer("Arne Slot");
        t.setClub(az);
        Stadion st = f.createStadion("AFAS Stadion");
        Adres a = f.createAdres("kaas", "8", 9012, "Alkmaar");
        st.setAdres(a);
        List<Speler> spelers = f.maakSpelers();
        for(Speler sp : spelers){
            sp.setClub(az);
        }
        az.setTrainer(t);
        az.setStadion(st);
        st.setClub(az);
        dao.addClub(az);
        dao.addSpelers(spelers);
        /*
        for(Competitie comp: s){
            dao.addCompetitie(comp);
        }*/
    }
}
