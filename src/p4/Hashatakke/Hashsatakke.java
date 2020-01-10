package p4.Hashatakke;

public class Hashsatakke {

    public static int hash(String s){
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash*31) + s.charAt(i);
        }
        return hash;
    }

    public static void main(String[] args) {
        System.out.println(hash("Bb"));
        System.out.println(hash("CC"));
    }

}
