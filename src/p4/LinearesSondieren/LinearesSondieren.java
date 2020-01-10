package p4.LinearesSondieren;

import p4.LinearesSondieren.Kontainer;

import java.util.Arrays;

public class LinearesSondieren {

    Kontainer[] list = new Kontainer[6];

    public LinearesSondieren(int size) {
        list = new Kontainer[size];
    }

    public void add(String input){
        for (char inputChar: input.toCharArray()) {
            int h = 13*inputChar%6;
            add(inputChar, h, 0);
        }
    }

    private void add(char inputChar, int h, int v){
        v = v;
        if(list[h+v]==null){
            list[h+v] = new Kontainer(inputChar, h, v+1);
        }else{
            add(inputChar, h, v+1);
        }
    }

    @Override
    public String toString() {
        return "LinearesSondieren{" +
                "list=" + Arrays.toString(list) +
                '}';
    }
}
