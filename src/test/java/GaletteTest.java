import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GaletteTest {
    private Galette galetteP,galette2,galette3,galette4;
    @BeforeEach
    public void initGaletteObject() throws Exception {
         galetteP = new Galette();
         galette2 = new Galette();
        galette3 = new Galette();
        galette4 = new Galette();
        Strategie s = new StrategieGourmet();
        MangeurDeGalettes Younes = new MangeurDeGalettes(s);
        galetteP  = new GalettePistache(galetteP);
        galette2 = new GaletteAllege(galette2);
        galette3 = new GaletteFrangipane(galette3);
        galette4 = new GaletteVegetarienne(galette4);

    }

    @Test
    public void TestCreationGalette(){
        assertEquals("Pistache",galetteP.getIngredient());
        assertEquals("rien",galette2.getIngredient()); //  bah la c'est leger :)
        assertEquals("Frangipane",galette3.getIngredient());
        assertEquals("Vert",galette4.getIngredient());
    }



    @Test
    public void TestGetPoids() throws Exception {
        assertEquals(2500, galetteP.getPoids());
        assertEquals(500, galette2.getPoids());
    }

    @Test
    public void TestGetPoidsPart() throws Exception {
        assertEquals(312.5, galetteP.getPoid_de_Part());
        assertEquals(62.5, galette2.getPoid_de_Part());

    }

    @Test
    public void TestGetListePartDeGalette() throws Exception {
        List<PartDeGalette> liste = galetteP.getListePartDeGalette();
        assertEquals(8, liste.size());
    }

}