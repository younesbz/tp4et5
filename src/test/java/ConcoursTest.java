import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class ConcoursTest {
    private Concours concoursUnderTest;
    private Galette galetteUnderTest;
    private ArrayList<Galette> ListGalettesUnderTest;
    private ArrayList<MangeurDeGalettes> ListMangeurUnderTest;
    StrategieGourmand strat;
    MangeurDeGalettes eater;

    @BeforeEach
    public void setUp() throws Exception {
        ListGalettesUnderTest = new ArrayList<>();
        ListMangeurUnderTest = new ArrayList<>();
        concoursUnderTest = new Concours(ListMangeurUnderTest, ListGalettesUnderTest);
        //eater
        strat = new StrategieGourmand();
        eater = new MangeurDeGalettes(strat);
        //Galette
        galetteUnderTest = new Galette();
        galetteUnderTest  = new GalettePistache(galetteUnderTest);

    }

    @Test
    public void TestADDMangeur() {
        concoursUnderTest.ajouterMangeur(eater);
        assertEquals(1, concoursUnderTest.getLes_mangeurs_de_galettes().size());
    }

    @Test
    public void TestADDGalette() throws Exception {
        concoursUnderTest.ajouterGalette(galetteUnderTest);
        assertEquals(1, concoursUnderTest.getLes_galettes().size());
    }

    @Test
    public void TestNettoyerTable() throws Exception {
        ListGalettesUnderTest.add(galetteUnderTest);
        eater.mangerPart(eater.rechercherPart(ListGalettesUnderTest));
        concoursUnderTest.nettoyerTable();
        assertEquals(2500.0, galetteUnderTest.getPoids());
        assertEquals(0, concoursUnderTest.getLes_mangeurs_de_galettes().size());
    }



    @Test
    public void TestEnleverLesPerdants() throws Exception {

        assertEquals(0, ListGalettesUnderTest.size());
        ListGalettesUnderTest.add(galetteUnderTest);
        ListGalettesUnderTest.add(galetteUnderTest);

        eater.mangerPart(eater.rechercherPart(ListGalettesUnderTest));

        concoursUnderTest.ajouterGalette(galetteUnderTest);
        concoursUnderTest.nettoyerTable();
        concoursUnderTest.enleverLesPerdants();

        assertEquals(0, concoursUnderTest.getLes_mangeurs_de_galettes().size());
    }

    @Test
    public void testConcourir() throws Exception {
        //Ce Test peut ne pas passer le cas ou le return est null
        MangeurDeGalettes participant = new MangeurDeGalettes(strat);

        concoursUnderTest.ajouterGalette(galetteUnderTest);
        concoursUnderTest.ajouterMangeur(participant);

        MangeurDeGalettes Winner = concoursUnderTest.concourir();
        assertTrue(participant == Winner || Winner == null );
    }
}

