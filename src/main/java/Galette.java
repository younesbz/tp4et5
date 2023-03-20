import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Galette implements Comparable<Galette> {


    private  ArrayList<PartDeGalette> ListePartDeGalette;
    private  double poid_de_Part;
    private  double poids;


    public Galette(double poids,int nbPart)  {

        poid_de_Part = poids /nbPart;
        ListePartDeGalette = new ArrayList<>();

        for (int i=0;i<nbPart;i++)
        {
            PartDeGalette pGalellte = new PartDeGalette(poid_de_Part);
            ListePartDeGalette.add(pGalellte);
        }
    }
    public ArrayList<PartDeGalette> getListePartDeGalette() {
        return ListePartDeGalette ;
    }

    public double getPoid_de_Part() {
        return poid_de_Part;
    }

    @Override
    public int compareTo(Galette o) {
        return (int) (o.getPoid_de_Part() - this.poid_de_Part);
    }
}
