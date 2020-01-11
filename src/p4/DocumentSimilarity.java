package p4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class DocumentSimilarity {

    private int numberOfFiles;
    private TST<int[]> trigramTree;
    //Ein Trigramm ist eine Folge von 3 Zeichen
    private final int WORD_LENGTH = 3;
    // index of the last inserted document
    private int documentIndex = 0;

    public DocumentSimilarity(String path){
        trigramTree = new TST<>();
        numberOfFiles = Objects.requireNonNull(new File(path).listFiles()).length;
        fillTST(path);
    }

    /**
     * bestimmen dann für jedes Wort die Trigramme
     * @param word
     * @return list of trigrams of the word
     */
    private List<String> createTrigrams(String word){
        List<String> trigrams = new ArrayList<>();
        if(word.length() < WORD_LENGTH){
            return trigrams;
        }
        trigrams.add(word.substring(0,WORD_LENGTH));
        trigrams.addAll(createTrigrams(word.substring(1)));
        return trigrams;
    }

    /**
     * fills the TST with all file in the directory pathToFiles
     * @param pathToFiles path of the files
     */
    private void fillTST(String pathToFiles){
        for(File file : new File(pathToFiles).listFiles()){
            System.out.println(documentIndex+"\t"+file.getName());
            List<String> words = new ArrayList<>();
            try {
                for(String line : Files.readAllLines(file.toPath())){
                    words.addAll(Arrays.asList(line.split("\\s")));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(String word: words){
                List<String> trigrams = createTrigrams(word);
                int finalDocumentIndex = documentIndex;
                trigrams.forEach(trigram -> {
                    if(!trigramTree.contains(trigram)){
                        //wählen Sie für den Wert in der Symboltabelle eine Liste der Länge der Anzahl der Dokumente
                        // und initialisieren Sie alle Elemente der Liste mit 0
                        trigramTree.put(trigram,new int[numberOfFiles]);
                    }
                    //Tragen Sie dann für einen Dokumenten-Index die Anzahl des Auftretens von Trigrammen korrekt ein.
                    trigramTree.get(trigram)[finalDocumentIndex]++;
                });
            }
            documentIndex++;
        }
    }

    /**
     * prints the distances between all documents in the tst
     */
    private void distanceForAllDocuments(){
        System.out.println("Doc\t|\tDoc\t|\tDis");
        for(int i = 0; i < numberOfFiles; i++){
            for (int j = i+1; j < numberOfFiles; j++){
                System.out.println(i+"\t|\t"+j+"\t|\t"+ getDistance(i,j));
            }
        }
    }

    /**
     *
     * @param documentNumberA index of a document
     * @param documentNumberB index of a document
     * @return distance between documentNumberA and documentNumberB
     */
    private double getDistance(int documentNumberA, int documentNumberB){
        int distance = 0;
        for(String trigram : trigramTree.keys()){
            distance += Math.pow(trigramTree.get(trigram)[documentNumberA] - trigramTree.get(trigram)[documentNumberB],2);
        }
        return Math.sqrt(distance);
    }

    public static void main(String[] args) {
        DocumentSimilarity ds = new DocumentSimilarity("./data/");
        ds.distanceForAllDocuments();
    }
}
