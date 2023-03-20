public class FrangipaneGaletteFactory implements GaletteFactory {
    public Galette createGalette() {
        return new FrangipaneGalette(2000.0,8);
    }
}
