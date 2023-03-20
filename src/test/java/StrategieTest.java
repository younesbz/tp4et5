import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StrategieTest {
    private List<Galette> Listgalettes;
    private MangeurDeGalettes Younes;

    private Strategie s,s2,s3;
    private Galette galette1,galette2,galette3,galette4;

    @BeforeEach
    void setUp() throws Exception {
        Listgalettes = new ArrayList<>();
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
        Listgalettes.add(galette4);

        Strategie s = new StrategieGourmand();
        MangeurDeGalettes YounesG = new MangeurDeGalettes(s);

        Strategie s2 = new StrategieGourmand();
        MangeurDeGalettes AslanGu = new MangeurDeGalettes(s2);

        Strategie s3 = new StrategieVege();
    }

    @Test
    void TestPartNull() throws Exception {

        assertNull(Younes.rechercherPart(Listgalettes));
    }
    @Test
    void testChoisirPartGalettesPistache() throws Exception {
        PartDeGalette part = s.rechercherPart(Listgalettes,0);
        assertEquals("GalettePistache", Listgalettes.getClass().getName());
        }

    @Test
    void testChoisirPartGalettesFrangipane() throws Exception {
        PartDeGalette part = s2.rechercherPart(Listgalettes,0);
        assertEquals("GaletteFrangipane", Listgalettes.getClass().getName());
    }
    @Test
    void testChoisirPartGalettesVege() throws Exception {
        PartDeGalette part = s3.rechercherPart(Listgalettes,0);
        assertEquals("GaletteVege", Listgalettes.getClass().getName());
    }
    }

