package p2.datastructures;

public class VectorWithEuclideanDistanceToRootVector implements Comparable<VectorWithEuclideanDistanceToRootVector> {
    public Vector vector;
    public int distance;

    public VectorWithEuclideanDistanceToRootVector(Vector vector, int distance) {
        this.vector = vector;
        this.distance = distance;
    }

    @Override
    public int compareTo(VectorWithEuclideanDistanceToRootVector vectorWithEuclideanDistanceToRootVector) {
        return this.distance- vectorWithEuclideanDistanceToRootVector.distance;
    }
}
