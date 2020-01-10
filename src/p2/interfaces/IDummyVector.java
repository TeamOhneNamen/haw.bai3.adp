package p2.interfaces;

import p2.datastructures.Vector;

import java.util.List;

public interface IDummyVector {

    /**
     * @return size of the Vector
     */
    int size();

    /**
     * get Value of the position in the Vector
     * @param i
     * @return Value on pos "i" in Vector
     */
    int get(int i);

    /**
     *
     * @param vectors
     * @param nearestVectorsQuantity
     * @return
     */
    List<Vector> nearestVectorsOfList(List<Vector> vectors, int nearestVectorsQuantity);

    /**
     *
     * @param pathToFile
     * @param nearestVectorsQuantity
     * @return
     */
    List<Vector> nearestVectorsOfListOfFile(String pathToFile, int nearestVectorsQuantity);

}
