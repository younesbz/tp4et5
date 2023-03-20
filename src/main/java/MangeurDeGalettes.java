
import java.util.List;

public class MangeurDeGalettes {
    protected double poids_Mange;
    protected boolean avoir_la_feve;
    protected Strategie myStrategy;

    public boolean isAvoir_la_feve() {
        return avoir_la_feve;
    }

    public MangeurDeGalettes(Strategie strat) {
        this.myStrategy = strat;
    }

    public void mangerPart(PartDeGalette part) {

        part.getMyGalette().remove(part);
        poids_Mange += part.getPoids();
        avoir_la_feve = part.contientFeve();
    }

    public PartDeGalette rechercherPart(List<Galette> galettes)  {
        return myStrategy.rechercherPart(galettes,poids_Mange);
    }

}
