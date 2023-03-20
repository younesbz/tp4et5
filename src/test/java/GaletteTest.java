import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GaletteTest {
    private Galette galette,galette2,galette3,galette4;
    @BeforeEach
    public void initGaletteObject() throws Exception {
         galette = new Galette();
         galette2 = new Galette();
        galette3 = new Galette();
        galette4 = new Galette();
        Strategie s = new StrategieGourmand();
        MangeurDeGalettes Younes = new MangeurDeGalettes(s);
        galette  = new GalettePistache(galette);
        galette2 = new GaletteAllege(galette2);
        galette3 = new GaletteFrangipane(galette3);
        galette4 = new GaletteVegetarienne(galette4);

    }

    @Test
    public void testCreationGalette(){
        assertEquals("Pistache",galette.getIngredient());
        assertEquals("rien",galette2.getIngredient());
        assertEquals("Frangipane",galette3.getIngredient());
        assertEquals("Vert",galette4.getIngredient());
    }



    @Test
    public void testGetPoids() throws Exception {
        assertEquals(2500, galette.getPoids());
        assertEquals(500, galette2.getPoids());
    }

    @Test
    public void testGetPoidsPart() throws Exception {
        assertEquals(312.5, galette.getPoid_de_Part());
        assertEquals(62.5, galette2.getPoid_de_Part());

    }

    @Test
    public void testGetListePartDeGalette() throws Exception {
        List<PartDeGalette> liste = galette.getListePartDeGalette();
        assertEquals(8, liste.size());
    }

}