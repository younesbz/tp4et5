import java.util.Comparator;
import java.util.List;

public class MangeurDeGalettes {
    protected double poids_Max;
    protected double poids_Mange;
    protected boolean avoir_la_feve;

    public boolean isAvoir_la_feve() {
        return avoir_la_feve;
    }

    public MangeurDeGalettes(double poids_Max) {
        this.poids_Max = poids_Max;
    }

    public void mangerPart(PartDeGalette part) {

        poids_Mange += part.getPoids();
        avoir_la_feve = part.contientFeve();
    }

    public PartDeGalette rechercherPart(List<Galette> galettes)  {
        return null;
    }

}
