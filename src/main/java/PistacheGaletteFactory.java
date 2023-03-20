public class PistacheGaletteFactory implements GaletteFactory {
    public Galette createGalette() {
        return new PistacheGalette(2500.0,8);
    }
}