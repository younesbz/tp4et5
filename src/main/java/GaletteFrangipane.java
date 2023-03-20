public class GaletteFrangipane extends Decorateur {

    public GaletteFrangipane(Galette galette) throws Exception {
        super(galette);
        this.galette.partistionGalette( 2000.0 , 8);
    }

    @Override
    public String getIngredient() {
        return galette.getIngredient() + "Frangipane";
    }


}