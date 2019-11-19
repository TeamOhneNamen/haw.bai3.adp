package p2.interfaces;

import p2.datastructures.Vector;

import java.util.List;

public interface IDummyVector {

    int size();
    int get(int i);
    List<Vector> nearestVectorsOfList(List<Vector> vectors, int nearestVectorsQuantity);
    List<Vector> nearestVectorsOfListOfFile(String pathToFile, int nearestVectorsQuantity);

}
