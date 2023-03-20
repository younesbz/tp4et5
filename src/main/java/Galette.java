
import java.util.ArrayList;

public class Galette implements Comparable<Galette> {


    private  ArrayList<PartDeGalette> ListePartDeGalette;
    private  double poid_de_Part;
    private  double poids;
    private String ingredients = "";

    public void partistionGalette(double poids,int nbPart)  {
        this.poids = poids ;
        poid_de_Part = poids /nbPart;
        ListePartDeGalette = new ArrayList<>();

        for (int i=0;i<nbPart;i++)
        {
            PartDeGalette pGalellte = new PartDeGalette(poid_de_Part,this);
            ListePartDeGalette.add(pGalellte);
        }
    }
    public Galette()  {
        poid_de_Part =0;
        ListePartDeGalette = new ArrayList<>();
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

    public double getPoids() {
        return poids;
    }

    public void remove(PartDeGalette part) {
        this.ListePartDeGalette.remove(part);
    }

    protected String getIngredient() {
        return this.ingredients;
    }
}
