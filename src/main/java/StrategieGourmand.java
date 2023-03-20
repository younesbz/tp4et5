
import java.util.Collections;
import java.util.List;

public class StrategieGourmand  implements Strategie{

    @Override
    public PartDeGalette rechercherPart(List<Galette> galettes, double poids_Mange) {
        double poids_galette_mangable =  2000 - poids_Mange ;
        Collections.sort(galettes);
        for (Galette galette : galettes) {
            if (galette.getClass().getName().equals("GalettePistache") && poids_galette_mangable> galette.getPoid_de_Part() ) {
                 return galette.getListePartDeGalette().get(0);
            }
            }
        for (Galette galette : galettes) {
            if ( poids_galette_mangable> galette.getPoid_de_Part() ) {
                return galette.getListePartDeGalette().get(0);
            }
        }


        return null;
    }
}
