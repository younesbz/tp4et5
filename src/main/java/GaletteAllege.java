public class GaletteAllege extends Decorateur {

    public GaletteAllege(Galette galette) throws Exception {
        super(galette);
        this.galette.partistionGalette( 500.0 , 8);
    }

    @Override
    public String getIngredient() {
        return galette.getIngredient() + "rien";
    }

}

