package p4.VerkettetesHashing;


import java.util.Arrays;

public class VerkettetesHashing {

    Kontainer[] list;

    public VerkettetesHashing(int givenSize) {
        list = new Kontainer[givenSize];

    }

    public void add(String input) {

        char[] inputChars = input.toCharArray();
        for (char inputChar: inputChars) {
            add(inputChar);
        }
    }

    private void add(char input) {
        int h = 13*input%6;
        if(list[h]==null){
            list[h] = new Kontainer<Character>();
        }
        if(!list[h].contains(input)){
            list[h].add(input);
        }
    }

    public void bestHash(){

    }

    @Override
    public String toString() {
        return "VerkettetesHashing{" +
                "list=" + Arrays.toString(list) +
                '}';
    }
}
