public class PistacheGaletteFactory implements GaletteFactory {
    public Galette createGalette() {
        return new PistacheGalette(500.0,8);
    }
}