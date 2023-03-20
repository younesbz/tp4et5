public class AllegeeGaletteFactory implements GaletteFactory {
    public Galette createGalette() {
        return new AllegeeGalette(500.0,8);
    }
}
