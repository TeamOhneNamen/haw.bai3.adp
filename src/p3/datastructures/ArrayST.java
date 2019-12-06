package p3.datastructures;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayST<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int maxLength;
    //current amount of elements in the array
    //the actual size of ArrayST
    private int length;
    private final int resizeStep = 10;
    private boolean sorted;

    public ArrayST(){
        int length = 10;
        this.sorted = false;
        this.maxLength = length;
        this.keys = (Key[]) new Object[this.maxLength];
        this.values = (Value[]) new Object[this.maxLength];
    }

    public ArrayST(boolean sorted, int maxLength){
        this.sorted = sorted;
        this.maxLength = maxLength;
        this.keys = (Key[]) new Object[this.maxLength];
        this.values = (Value[]) new Object[this.maxLength];
    }

    public void set(Key[] keys, Value[] values){
        if(keys.length != values.length){
            throw new RuntimeException("keys and values should have the same length");
        }
        for (int i = 0; i < keys.length; i++) {
            this.set(keys[i], values[i]);
        }
    }

    public void set(Key key, Value value){
        this.length++;
        if(this.length() == this.maxLength){ this.resize(); }
        this.keys[this.length()-1] = key;
        this.values[this.length()-1] = value;
    }

    public Value get(Key key){
        for (int index = 0; index < this.length(); index++) {
            if(this.keys[index].equals(key)){
                if(this.sorted){sort(index);}
                return this.values[index];
            }
        }
        throw new NoSuchElementException("The there is no such Key: "+key.toString());
    }

    private void sort(int index){
        Key[] tempkeys = Arrays.copyOf(keys,keys.length);
        Value[] tempvalues = Arrays.copyOf(values,values.length);
        int j = 0;
        this.keys[j] = tempkeys[index];
        this.values[j] = tempvalues[index];

        for (int i = 1; i < this.length(); i++) {
            //skip index
            if(j == index){ j++;}
            this.keys[i] = tempkeys[j];
            this.values[i] = tempvalues[j];
            j++;
        }
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.length(); i++) {
            stringBuffer.append("{");
            stringBuffer.append(this.keys[i].toString());
            stringBuffer.append(" : ");
            stringBuffer.append(this.values[i].toString());
            stringBuffer.append("}");
            if (i < this.length()-1) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }

    /***
     * resize keys and values to insert more key-value-pairs
     * resize by {@link #resizeStep}
     */
    private void resize(){
        this.keys = Arrays.copyOf(this.keys, this.maxLength+this.resizeStep);
        this.values = Arrays.copyOf(this.values, this.maxLength+this.resizeStep);
    }

    public int length() {
        return this.length;
    }
}
