import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Concours {
    private ArrayList<MangeurDeGalettes> les_mangeurs_de_galettes;
    private ArrayList<Galette> les_galettes;

    public Concours(ArrayList<MangeurDeGalettes> les_mangeurs_de_galettes, ArrayList<Galette> les_galettes) {
        this.les_mangeurs_de_galettes = les_mangeurs_de_galettes;
        this.les_galettes = les_galettes;
    }


    public void nettoyerTable() {
        for(int i=0 ; i < les_galettes.size() ; i++){
            if(les_galettes.get(i).getListePartDeGalette().size() == 0){
                les_galettes.remove(i);
            }
        }
    }

    public void enleverLesPerdants()  {
        for(int i=0 ; i < les_mangeurs_de_galettes.size() ; i++){
            boolean test_if_they_can_eat_any_galettes = les_mangeurs_de_galettes.get(i).rechercherPart(this.les_galettes)==null;
            if ( test_if_they_can_eat_any_galettes ) {
                les_mangeurs_de_galettes.remove(i);
            }
        }
    }

    public MangeurDeGalettes concourir() {
//manire de creatoin dun galette
        GaletteFactory galetteFactory = new FrangipaneGaletteFactory();
        Galette galette = galetteFactory.createGalette();

        Random random = new Random();
        int index_Aleatoire_de_galette = random.nextInt(les_galettes.size());
        Galette galette_choisi_aleatoirement = les_galettes.get(index_Aleatoire_de_galette);
        int index_Aleatoire_de_pergalette = random.nextInt(galette_choisi_aleatoirement.getListePartDeGalette().size());
        les_galettes.get(index_Aleatoire_de_galette).getListePartDeGalette().get(index_Aleatoire_de_pergalette).setPossedefeve(true);
        nettoyerTable();
        enleverLesPerdants();
        while (!les_galettes.isEmpty() || !les_mangeurs_de_galettes.isEmpty()) {
            for (MangeurDeGalettes mangeur : les_mangeurs_de_galettes) {
                PartDeGalette part = mangeur.rechercherPart(les_galettes);
                mangeur.mangerPart(part);
                if (mangeur.isAvoir_la_feve())
                {
                    return mangeur;
                }
            }

            nettoyerTable();
            enleverLesPerdants();
        }
        return null;
    }


}
