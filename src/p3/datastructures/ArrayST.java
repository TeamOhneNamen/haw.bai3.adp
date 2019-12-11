package p3.datastructures;

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

    /**
     * empty constructor
     */
    public ArrayST(){
        int length = 10;
        this.sorted = false;
        this.maxLength = length;
        this.keys = (Key[]) new Object[this.maxLength];
        this.values = (Value[]) new Object[this.maxLength];
    }

    /**
     * constructor with maxLength and a boolean to set if the list should be automaticly sorted on gets
     * @param sorted
     * @param maxLength
     */
    public ArrayST(boolean sorted, int maxLength){
        this.sorted = sorted;
        this.maxLength = maxLength;
        this.keys = (Key[]) new Object[this.maxLength];
        this.values = (Value[]) new Object[this.maxLength];
    }

    /**
     * set a bunch of Keys and Values at the end of the ArrayST resize if the length is to small
     * the first Key has to group up with the first value aso.
     *
     * ??? maby also sort if "accsess"
     *
     * @param keys
     * @param values
     * @throws RuntimeException if the keys list and the value list have not the same length
     */
    public void set(Key[] keys, Value[] values){
        if(keys.length != values.length){
            throw new RuntimeException("keys and values should have the same length");
        }
        for (int i = 0; i < keys.length; i++) {
            this.set(keys[i], values[i]);
        }
    }

    /**
     * add a Key and Value Touple at the end of the ArrayST resize if the length is to small
     *
     * ??? maby also sort if "accsess"
     *
     * @param key
     * @param value
     */
    public void set(Key key, Value value){
        this.length++;
        if(this.length() == this.maxLength){ this.resize(); }
        this.keys[this.length()-1] = key;
        this.values[this.length()-1] = value;
    }

    /**
     * get the element with the key 'key' and sort the ArrayST with the index of 'key'
     * @param key
     * @return
     */
    public Value get(Key key){
        for (int index = 0; index < this.length(); index++) {
            if(this.keys[index].equals(key)){
                if(this.sorted){sort(index);}
                return this.values[index];
            }
        }
        throw new NoSuchElementException("The there is no such Key: "+key.toString());
    }

    /**
     * sort the ArrayST in the way that the element in index "index" is on pos '0'
     * @param index
     */
    private void sort(int index){
        Key[] tempkeys = Arrays.copyOf(keys,keys.length);
        Value[] tempvalues = Arrays.copyOf(values,values.length);
        int j = 0;
        this.keys[j] = tempkeys[index];
        this.values[j] = tempvalues[index];

        for (int i = 1; i < this.length(); i++) {
            //skip index
            //now the j and i index are the same val
            if(j == index){ j++;}
            this.keys[i] = tempkeys[j];
            this.values[i] = tempvalues[j];
            j++;
        }
    }

    /**
     * print the ArrayST
     * @return
     */
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

    /**
     * getter for the length
     * @return
     */
    public int length() {
        return this.length;
    }
}
