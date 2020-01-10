package p4.LinearesSondieren;

public class Kontainer {

    int versuche;
    int hashCode;
    char inputChar;

    public Kontainer(char inputChar, int hash, int versuche) {
        this.inputChar = inputChar;
        this.hashCode = hash;
        this.versuche = versuche;
    }

    @Override
    public String toString() {
        return "Kontainer{" +
                "versuche=" + versuche +
                ", hashCode=" + hashCode +
                ", inputChar=" + inputChar +
                '}';
    }
}
