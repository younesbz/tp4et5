
public abstract class Decorateur extends Galette {
    protected Galette galette;

    public Decorateur(Galette galette) {
        super();
        this.galette = galette;
    }

    public abstract String getIngredient();



}



