import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StrategieVeganTest {
    private StrategieVege strategie;
    private List<Galette> galettes;

    @BeforeEach
    void setup() throws Exception {
        strategie = new StrategieVege();
        galettes = new ArrayList<>();
        Galette galetteNormal = new Galette();
        GalettePistache galette1 = new GalettePistache(galetteNormal);
        GaletteFrangipane galette2 = new GaletteFrangipane(galetteNormal);
        GaletteVegetarienne galette3 = new GaletteVegetarienne(galetteNormal);

        galettes.add(galette1);
        galettes.add(galette2);
        galettes.add(galette3);

    }

    @Test
    void testChoisirPartGalettesVeganDisponible() throws Exception {
        PartDeGalette part = strategie.rechercherPart(galettes,500);
        assertNotNull(part);

        for (Galette galette : galettes) {
            if (galette.getListePartDeGalette().contains(part)) {
                assertEquals("GaletteVegan", galette.getClass().getName());
            }

        }
    }





}
