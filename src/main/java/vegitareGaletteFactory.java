public class vegitareGaletteFactory implements GaletteFactory {
    public Galette createGalette() {
        return new vegitarGalette(1500.0,8);
    }
}
