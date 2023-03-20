import java.util.ArrayList;
import java.util.List;

public class Subject {


    private final List<Observer> spectateurs = new ArrayList<>();

    public void addSpectateur(Observer spectateur) {
        spectateurs.add(spectateur);
    }

    public void removeSpectateur(Observer spectateur) {
        spectateurs.remove(spectateur);
    }
    public List<Observer> getSpectateurs() {
        return spectateurs;
    }

    public void notifySpectateur() {
        for (Observer spectateur : spectateurs) {
            spectateur.update();
        }
    }
}

