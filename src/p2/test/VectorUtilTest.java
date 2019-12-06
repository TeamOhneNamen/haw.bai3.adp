//package p2.test;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import p2.datastructures.Vector;
//import p2.util.VectorUtil;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class VectorUtilTest {
//
//    private List<Vector> vectorListSize3;
//    private String vectorListSize3String;
//    private final String PATH_TO_FILE;
//
//    VectorUtilTest() {
//        PATH_TO_FILE = "./src/p2/resources/VectorUtilTest.txt";
//    }
//
//    @BeforeEach
//    void SetUp() {
//        this.vectorListSize3 = List.of(new Vector(List.of(1,2,3)), new Vector(List.of(4,5,6)), new Vector(List.of(7,8,9)));
//        this.vectorListSize3String = "[1, 2, 3]\n[4, 5, 6]\n[7, 8, 9]\n";
//    }
//
//    @Test
//    void vectorListToStringTestVectorListSize3(){
//        assertEquals(this.vectorListSize3String,VectorUtil.vectorListToString(this.vectorListSize3));
//    }
//
//    @Test
//    void generateVectorListOfFile(){
//        VectorUtil.writeToFile(this.vectorListSize3, PATH_TO_FILE);
//        assertEquals(this.vectorListSize3,VectorUtil.generateVectorListOfFile(PATH_TO_FILE));
//    }
//}
