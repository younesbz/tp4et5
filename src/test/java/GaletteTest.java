import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GaletteTest {
    private Galette galette,galette2;
    @BeforeEach
    public void initGaletteObject() throws Exception {
         galette = new Galette();
         galette2 = new Galette();
        Strategie s = new StrategieGourmand();
        MangeurDeGalettes Younes = new MangeurDeGalettes(s);
        galette  = new GalettePistache(galette);
        galette2 = new GaletteAllege(galette2);
    }

    @Test
    public void testCreationGalette(){
        assertEquals("Pistache",galette.getIngredient());
        assertEquals("rien",galette2.getIngredient());
    }

}