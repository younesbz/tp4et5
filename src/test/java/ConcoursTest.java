import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class ConcoursTest {

    private Concours concours;
    private Galette galette;
    private ArrayList<Galette> galettes;
    private ArrayList<MangeurDeGalettes> mangeurs;

    StrategieGourmand strat;

    @BeforeEach
    public void setUp() {

        galettes = new ArrayList<>();
        mangeurs = new ArrayList<>();
        concours = new Concours(mangeurs, galettes);
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
        galette = new Galette();
        galette  = new GalettePistache(galette);
        concours.ajouterGalette(galette);
        assertEquals(1, concours.getLes_galettes().size());
    }

    @Test
    public void testNettoyerTable() throws Exception {
        Galette galette1 = new Galette();
        GalettePistache gPis = new GalettePistache(galette1);
        assertEquals(0, galettes.size());

        galettes.add(gPis);
        MangeurDeGalettes mangeur = new MangeurDeGalettes(strat);
        mangeur.mangerPart(mangeur.rechercherPart(galettes));

        concours.nettoyerTable();

        assertEquals(0, concours.getLes_mangeurs_de_galettes().size());
    }



    @Test
    public void testEnleverLesPerdants() throws Exception {
        Galette galette1 = new Galette();
        GalettePistache gPis = new GalettePistache(galette1);
        assertEquals(0, galettes.size());
        galettes.add(gPis);
        galettes.add(gPis);

        MangeurDeGalettes mangeur = new MangeurDeGalettes(strat);
        mangeur.mangerPart(mangeur.rechercherPart(galettes));

        concours.ajouterGalette(gPis);
        concours.nettoyerTable();
        concours.enleverLesPerdants();

        assertEquals(0, concours.getLes_mangeurs_de_galettes().size());
    }


    @Test
    public void testConcourir() throws Exception {
        Galette galette1 = new Galette();
        GalettePistache gPis = new GalettePistache(galette1);


        MangeurDeGalettes mangeur = new MangeurDeGalettes(strat);

        concours.ajouterGalette(gPis);
        concours.ajouterMangeur(mangeur);

        MangeurDeGalettes mangeurG = concours.concourir();
        assertEquals(mangeur,mangeurG);
    }


    @Test
    public void testConcourirPasDeGagnant() throws Exception {
        Galette galette1 = new Galette();
        GalettePistache gPis = new GalettePistache(galette1);
        assertEquals(0, galettes.size());

        MangeurDeGalettes mangeur = new MangeurDeGalettes(strat);

        concours.ajouterGalette(gPis);
        concours.ajouterMangeur(mangeur);


        MangeurDeGalettes mangeur1 = concours.concourir();
    }

}

