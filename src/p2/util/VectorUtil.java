package p2.util;

import p2.datastructures.Vector;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class VectorUtil {

    /**
     * generating a vector from File
     * @param pathToFile
     * @return List of all Parsed Vectors of the File
     */
    public static List<Vector> generateVectorListOfFile(String pathToFile){
        List<Vector> vectors = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(pathToFile))) {
            stream.forEach(line -> vectors.add(Vector.ofString(line)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vectors;
    }

    /**
     * writer for Vectors into a File
     * @param vectors
     * @param pathToFile
     */
    public static void writeToFile(List<Vector> vectors, String pathToFile){
        String str = VectorUtil.vectorListToString(vectors);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile))) {
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * make a List of Random Vertices withe the length of "listSize" the Vertices have to be between the "minValue" and the "maxValue"
     * @param listSize
     * @param vectorLength
     * @param minValue
     * @param maxValue
     * @return List of Vertices
     */
    public static List<Vector> generateVectorList(int listSize, int vectorLength, int minValue, int maxValue){
        List<Vector> vectorList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            List<Integer> vectorValues = new ArrayList<>();
            for (int j = 0; j < vectorLength; j++) {
                int value = ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
                vectorValues.add(value);
            }
            vectorList.add(new Vector(vectorValues));
        }
        return vectorList;
    }

    /**
     * Makes String from Vertices
     * @param vectors
     * @return String of vertices
     */
    public static String vectorListToString(List<Vector> vectors){
        StringBuffer stringBuffer = new StringBuffer();
        vectors.forEach(element -> (stringBuffer).append(element.toString()).append("\n"));
        return stringBuffer.toString();
    }
}
