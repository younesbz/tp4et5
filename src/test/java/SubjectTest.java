import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {
    private Subject theSubject;
    private Observer theObserver;
    public void initObjectTest() throws Exception {
        theSubject = new Subject();
        theObserver = new Spectateur();

    }

    @Test
    void addSpectateur() {

        theSubject.addSpectateur(theObserver);
        assertTrue(theSubject.getSpectateurs().contains(theObserver));
    }

    @Test
    void removeSpectateur() {

        theSubject.addSpectateur(theObserver);

        theSubject.removeSpectateur(theObserver);
        assertFalse(theSubject.getSpectateurs().contains(theObserver));
    }

    @Test
    void notifySpectateur() {
        MangeurDeGalettes AslaN = Mockito.mock(MangeurDeGalettes.class);
        Spectateur Spec = Mockito.mock(Spectateur.class);

        theSubject.addSpectateur(Spec);

        theSubject.notifySpectateur(AslaN);

        Mockito.verify(Spec).update(AslaN);
    }
}