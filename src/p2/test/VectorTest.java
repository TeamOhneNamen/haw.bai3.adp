package p2.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import p2.datastructures.Vector;
import p2.util.VectorUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VectorTest {

    private final String PATH_TO_FILE;
    private List<Vector> vectors;
    private Vector vectorSize3;
    private Vector vectorSize10;
    private Vector vectorSize10LongerNumbers;
    private List<Vector> vectorSize3ListSize4;
    private List<Vector> nearest2VectorsOfVectorSize3AndVectorSize3ListSize4;

    VectorTest() {
        PATH_TO_FILE = "./src/p2/resources/VectorUtilTest.txt";
    }

    @BeforeEach
    void SetUp() {
        this.vectorSize3 = new Vector(List.of(1,2,3));
        this.vectorSize10 = new Vector(List.of(0,1,2,3,4,5,6,7,8,9));
        this.vectorSize10LongerNumbers = new Vector(List.of(0,1,2222,35656,4,56,689,7,8,9));
        this.vectorSize3ListSize4 = List.of(new Vector(List.of(54,74,6)), new Vector(List.of(1,2,3)), new Vector(List.of(4,5,6)), new Vector(List.of(7,8,9)));
        this.nearest2VectorsOfVectorSize3AndVectorSize3ListSize4 = List.of(new Vector(List.of(1,2,3)), new Vector(List.of(4,5,6)));
    }

    @Test
    void ofStringTestVectorSize3(){
        assertEquals(this.vectorSize3, Vector.ofString(this.vectorSize3.toString()));
    }

    @Test
    void ofStringTestVectorSize10(){
        assertEquals(this.vectorSize10, Vector.ofString(this.vectorSize10.toString()));
    }

    @Test
    void ofStringTestVectorSize10LongerNumbers(){
        assertEquals(this.vectorSize10LongerNumbers, Vector.ofString(this.vectorSize10LongerNumbers.toString()));
    }

    @Test
    void nearestVectorsOfList(){
        assertEquals(this.nearest2VectorsOfVectorSize3AndVectorSize3ListSize4, this.vectorSize3.nearestVectorsOfList(this.vectorSize3ListSize4, 2));
    }

    @Test
    void nearestVectorsOfListLongRandomList(){
        List<Vector> vectors = VectorUtil.generateVectorList(1000, 3, 1, 1000);
        String pathToFile = "./src/p2/resources/nearestVectorsOfListLongRandomList"+".txt";
        VectorUtil.writeToFile(vectors,pathToFile);

        int nearestVectorsQuantity = 3;
        assertEquals(nearestVectorsQuantity, this.vectorSize3.nearestVectorsOfListOfFile(pathToFile, nearestVectorsQuantity).size());
    }
}
