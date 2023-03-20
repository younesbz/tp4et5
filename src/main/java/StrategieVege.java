import java.util.Collections;
import java.util.List;

public class StrategieVege implements Strategie{

    @Override
    public PartDeGalette rechercherPart(List<Galette> galettes,double poids_Mange) {
        double poids_galette_mangable =  500 - poids_Mange ;
        Collections.sort(galettes);
        for(int i=galettes.size();i>0;i--){
            if (galettes.get(i).getClass().getName().equals("vegitarGalette") && poids_galette_mangable> galettes.get(i).getPoid_de_Part() ) {
                return galettes.get(i).getListePartDeGalette().get(i);
            }
        }
        return null;
    }
}
