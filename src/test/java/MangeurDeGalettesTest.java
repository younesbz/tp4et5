import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MangeurDeGalettesTest {

    @Test
    void mangerPart() {
        Strategie strategie = new StrategieGourmand();
        MangeurDeGalettes mangeurDeGalettes = new MangeurDeGalettes(strategie);
        GaletteFactory galetteFactory = new PistacheGaletteFactory();

        ArrayList<Galette> galettes = new ArrayList<>();
        galettes.add(galetteFactory.createGalette());
        galetteFactory = new vegitareGaletteFactory();
        galettes.add(galetteFactory.createGalette());
        galetteFactory = new AllegeeGaletteFactory();
        galettes.add(galetteFactory.createGalette());

        assertEquals(galettes.get(0).getListePartDeGalette().get(0),mangeurDeGalettes.rechercherPart(galettes));

    }

    @Test
    void rechercherPart() {
    }
}