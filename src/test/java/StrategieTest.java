import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StrategieTest {
    private ArrayList<Galette> Listgalettes;
    private MangeurDeGalettes Younes,Aslan;

    private Strategie s,s2,s3;
    private Galette galette1,galette2,galette3,galette4;

    @BeforeEach
    void setUp() throws Exception {
        Listgalettes = new ArrayList<Galette>();
        galette1 = new Galette();
        galette2 = new Galette();
        galette3 = new Galette();
        galette4 = new Galette();


        galette1  = new GalettePistache(galette1);
        galette2 = new GaletteAllege(galette2);
        galette3 = new GaletteFrangipane(galette3);
        galette4 = new GaletteVegetarienne(galette4);
        Listgalettes.add(galette1);
        Listgalettes.add(galette2);
        Listgalettes.add(galette3);


         s = new StrategieGourmand();
         Younes = new MangeurDeGalettes(s);

         s2 = new StrategieVege();
         Aslan = new MangeurDeGalettes(s2);

        s3 = new StrategieGourmet();
    }

    @Test
    void TestPartNull() throws Exception {
        assertNull(Aslan.rechercherPart(Listgalettes));
    }
    @Test
    void testChoisirPartGalettesPistache() throws Exception {
        PartDeGalette part = s.rechercherPart(Listgalettes,0);
        assertEquals("GalettePistache", part.getMyGalette().getClass().getName());
        }

    @Test
    void testChoisirPartGalettesFrangipane() throws Exception {
        PartDeGalette part = s3.rechercherPart(Listgalettes,0);
        assertEquals("GaletteFrangipane", part.getMyGalette().getClass().getName());
    }
    @Test
    void testChoisirPartGalettesVege() throws Exception {
        Listgalettes.add(galette4);

        PartDeGalette part = s2.rechercherPart(Listgalettes,0);
        assertEquals("GaletteVegetarienne", part.getMyGalette().getClass().getName());
    }
    }

