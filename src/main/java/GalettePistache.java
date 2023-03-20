public class GalettePistache extends Decorateur {

    public GalettePistache(Galette galette) throws Exception {
        super(galette);
        this.galette.partistionGalette(2500.0 , 8);
    }

    @Override
    public String getIngredient() {
        return this.galette.getIngredient() + "Pistache";
    }


}