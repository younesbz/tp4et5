import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



public class MangeurDeGalettesTest {

    private MangeurDeGalettes eater;
    private Galette theG,g1,g2;
    private List<Galette> myL_G;



    @BeforeEach
    public void setUp() throws Exception {
        Strategie s = new StrategieGourmand();
        eater = new MangeurDeGalettes(s);
        theG = new GaletteFrangipane(theG);
        myL_G = new ArrayList<Galette>();
        g1 = new Galette();
        g2 = new Galette();
        g1 = new GalettePistache(g1);
        g2 = new GaletteFrangipane(g2);
    }

    @Test
    public void testMangerPart()  {
        PartDeGalette part = new PartDeGalette(250.0,theG);
        eater.mangerPart(part);
        //assertFalse(eater.avoir_la_feve);
        assertEquals(250.0, eater.poids_Mange);
    }


    @Test
    public void testRechercherPart() throws Exception {
        myL_G.add(g1);
        myL_G.add(g2);

        PartDeGalette part = eater.rechercherPart(myL_G);
        assertTrue(g1.getListePartDeGalette().contains(part));
        assertFalse(g2.getListePartDeGalette().contains(part));
    }
}

