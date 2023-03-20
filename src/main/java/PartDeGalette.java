public class PartDeGalette {
    private boolean feve;
    private double poids;

    private Galette myGalette;

    public Galette getMyGalette() {
        return myGalette;
    }



    public PartDeGalette(Double poids ,Galette galette ) {
        this.poids = poids;
        this.feve = false;
        this.myGalette = galette;
    }
    public double getPoids() {
        return 0;
    }

    public boolean contientFeve() {
        return false ;
    }

    public void setPossedefeve(boolean b) {
        feve = b;
    }



}
