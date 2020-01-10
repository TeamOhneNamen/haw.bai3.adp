package p4.VerkettetesHashing;

import java.util.ArrayList;

public class Kontainer<T> extends ArrayList<T> {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.size(); i++) {
            if(i!=0){
                sb.append(",");
            }
            sb.append(this.get(i).toString());
        }

        return sb.toString() + "]";
    }
}
