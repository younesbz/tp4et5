
import java.util.Collections;
import java.util.List;

public class Gourmand extends MangeurDeGalettes{

    public Gourmand() {
        super(2000.0);
    }
    public PartDeGalette rechercherPart(List<Galette> galettes)  {
        Collections.sort(galettes);
        return  galettes.get(0).getListePartDeGalette().get(0);

    }
}
