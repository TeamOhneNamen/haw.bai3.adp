package p2.datastructures;

//inspired by: https://docs.oracle.com/javase/7/docs/api/java/util/Vector.html

import p2.util.MergeSort;
import p2.util.VectorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

public class Vector implements Comparable<Vector> {
    private List<Integer> data;
    private static final Pattern PATTERN = Pattern.compile("[0-9]");

    public Vector() {
        this.data = new ArrayList<>();
    }

    public Vector(int e) {
        this.data = new ArrayList<>();
        this.data.add(e);
    }

    public Vector(Collection<Integer> c) {
        this.data = new ArrayList<>();
        this.data.addAll(c);
    }

    //parses a String and creates a Vector of it
    public static Vector ofString(String vectorString){
        char[] vectorCharArray = vectorString.toCharArray();
        List<Integer> intList = new ArrayList<>();
        StringBuffer numberAsCharSequence = new StringBuffer();
        for (int i = 0; i < vectorCharArray.length; i++) {
            CharSequence charSequence = new StringBuffer().append(vectorCharArray[i]);
            if(PATTERN.matcher(charSequence).matches()){
                (numberAsCharSequence).append(charSequence);
            }else {
                if(numberAsCharSequence.length() > 0) {
                    int number = Integer.valueOf(numberAsCharSequence.toString());
                    intList.add(number);
                }
                numberAsCharSequence = new StringBuffer();
            }
        }
        return new Vector(intList);
    }

    public int size(){
        return this.data.size();
    }

    public int get(int i){
        return this.data.get(i);
    }

    public List<Vector> nearestVectorsOfList(List<Vector> vectors, int nearestVectorsQuantity){
        if(nearestVectorsQuantity > vectors.size()){
            throw new IndexOutOfBoundsException();
        }
        List<VectorWithEuclideanDistanceToRootVector> vectorWithEuclideanDistanceToRootVectors = new ArrayList<>();
        vectors.forEach(vector -> {
            vectorWithEuclideanDistanceToRootVectors.add(new VectorWithEuclideanDistanceToRootVector(vector,this.compareTo(vector)));
        });

        List<VectorWithEuclideanDistanceToRootVector> sortedList = MergeSort.bottomUp(vectorWithEuclideanDistanceToRootVectors);
        List<Vector> returnList = new ArrayList<>();
        for (int i = 0; i < nearestVectorsQuantity; i++) {
            returnList.add(sortedList.get(i).vector);
        }
        return returnList;
    }

    public List<Vector> nearestVectorsOfListOfFile(String pathToFile, int nearestVectorsQuantity){
        return this.nearestVectorsOfList(VectorUtil.generateVectorListOfFile(pathToFile), nearestVectorsQuantity);
    }

    //based on: https://en.wikipedia.org/wiki/Euclidean_distance
    @Override
    public int compareTo(Vector vector) throws IncompatibleClassChangeError{
        if(this.size() != vector.size()){
            throw new IncompatibleClassChangeError();
        }
        int distance = 0;
        int partUnderTheSquareRoot = 0;
        for (int i = 0; i < this.size(); i++) {
            int sum = ((Double)Math.pow(this.get(i) + vector.get(i), 2)).intValue();
            partUnderTheSquareRoot += sum;
        }
        return ((Double)Math.sqrt(partUnderTheSquareRoot)).intValue();
    }

    @Override
    public String toString(){
        return this.data.toString();
    }

    @Override
    public boolean equals(Object o){
        if (!(o.getClass().equals(this.getClass()))) {
            return false;
        } else if (((Vector) o).size() != this.size()) {
            return false;
        } else {
            for (int i = 0; i < this.size(); i++) {
                if(!((Integer)this.get(i)).equals(((Vector) o).get(i))){
                    return false;
                }
            }
            return true;
        }
    }
}
