import java.util.ArrayList;

public class GaletteFrangipane extends Decorateur {

    public GaletteFrangipane(Galette galette) throws Exception {
        super(galette);
        this.galette.partistionGalette( 2000.0 , 8);
    }

    @Override
    public String getIngredient() {
        return galette.getIngredient() + "Frangipane";
    }

    public ArrayList<PartDeGalette> getListePartDeGalette() {
        return this.galette.getListePartDeGalette() ;
    }


}