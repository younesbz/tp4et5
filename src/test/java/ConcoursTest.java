import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class ConcoursTest {

    private Concours concours;
    private ArrayList<Galette> galettes;
    private ArrayList<MangeurDeGalettes> mangeurs;

    StrategieGourmand strat;

    @BeforeEach
    public void setUp() {
        concours = new Concours();
        galettes = new ArrayList<>();
        mangeurs = new ArrayList<>();
        strat = new StrategieGourmand();
    }

    @Test
    public void testAjouterMangeur() {
        MangeurDeGalettes mangeur = new MangeurDeGalettes(strat);
        concours.ajouterMangeur(mangeur);
        assertEquals(1, concours.getLes_mangeurs_de_galettes().size());
    }

    @Test
    public void testAjouterGalette() throws Exception {
        Galette galette = new Galette();
        concours.ajouterGalette(galette);
        assertEquals(1, concours.getLes_mangeurs_de_galettes().size());
    }

    @Test
    public void testNettoyerTable() throws Exception {
        Galette galette1 = new Galette();
        GalettePistache gPis = new GalettePistache(galette1);
        assertEquals(0, galettes.size());

        galettes.add(gPis);
        MangeurDeGalettes mangeur = new MangeurDeGalettes(strat);
        mangeur.mangerPart(mangeur.rechercherPart(galettes));

        concours.ajouterGalette(gPis);
        concours.nettoyerTable();

        assertEquals(0, concours.getLes_mangeurs_de_galettes().size());
    }



    @Test
    public void testEnleverLesPerdants() throws Exception {
        Galette galette1 = new Galette(1000.50,1);
        GalettePistache gPis = new GalettePistache(galette1);
        assertEquals(0, galettes.size());
        galettes.add(gPis);
        galettes.add(gPis);

        MangeurDeGalettes mangeur = new MangeurDeGalettes(1000.50,strat);
        mangeur.mangerPart(mangeur.rechercherPart(galettes));

        concours.ajouterGalette(gPis);
        concours.nettoyerTable();
        concours.enleverLesPerdants();

        assertEquals(0, concours.getMangeurs().size());
    }


    @Test
    public void testConcourir() throws Exception {
        Galette galette1 = new Galette(1000.50,1);
        GalettePistache gPis = new GalettePistache(galette1);
        assertEquals(0, galettes.size());


        MangeurDeGalettes mangeur = new MangeurDeGalettes(1000.50,strat);

        concours.ajouterGalette(gPis);
        concours.ajouterMangeur(mangeur);

        MangeurDeGalettes mangeurG = concours.concourir();
        assertEquals(mangeur,mangeurG);
    }


    @Test
    public void testConcourirPasDeGagnant() throws Exception {
        Galette galette1 = new Galette(1000.50,4);
        GalettePistache gPis = new GalettePistache(galette1);
        assertEquals(0, galettes.size());

        MangeurDeGalettes mangeur = new MangeurDeGalettes(100.50,strat);

        concours.ajouterGalette(gPis);
        concours.ajouterMangeur(mangeur);


        MangeurDeGalettes mangeur1 = concours.concourir();
        //assertEquals(mangeur,mangeur1);
    }

    @Test
    public void testConcourirException() throws Exception {
        Galette galette1 = new Galette(1000.50,1);
        GalettePistache gPis = new GalettePistache(galette1);
        assertEquals(0, galettes.size());


        MangeurDeGalettes mangeur = new MangeurDeGalettes(1000.50,strat);

        //On a ajoute le mangeur au concours mais pas la galette
        concours.ajouterMangeur(mangeur);

        assertThrows(IllegalArgumentException.class, () -> concours.concourir());
    }

}

