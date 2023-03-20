public class AllegeeGaletteFactory implements GaletteFactory {
    public Galette createGalette() {
        return new AllegeeGalette(800.0,8);
    }
}
