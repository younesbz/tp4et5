public class GaletteVegetarienne extends Decorateur {

    public GaletteVegetarienne(Galette galette) throws Exception {
        super(galette);
        this.galette.partistionGalette(1500.0 , 8);
    }

    @Override
    public String getIngredient() {
        return galette.getIngredient() + "Vert";
    }


}