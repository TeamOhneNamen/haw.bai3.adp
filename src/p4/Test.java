package p4;

public class Test {
    static int R = 3;
    static int Q = 13;
    static int RM = 9;
    public static void main(String[] args) {
        System.out.println("recu Hash: "+hash("BCA",3));
        String irerativeString = "BBCBCA";
        System.out.println("iter Hash: "+iterativeHash(irerativeString,irerativeString.length(),4));
    }
    private static int hash(String key, int M ) {
        int h=0;
        for(int i=0; i < M; i++) {
            int bracket = (R * h + getCode(key.charAt(i)));
            h=bracket % Q;
        }
        return h;
    }

    private static int iterativeHash(String key, int M , int i) {
        return ((1 + getCode(key.charAt( Math.abs(i-M)))*(Q-RM))*R
                + getCode(key.charAt(i))) %Q;
    }

    private static int getCode(char c) {
        switch(c){
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
        }
        return -1;
    }

}
