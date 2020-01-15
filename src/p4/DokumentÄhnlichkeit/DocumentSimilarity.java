package p4.DokumentÄhnlichkeit;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class DocumentSimilarity {

    private TST<int[]> tstTree;
    private int numberOfFiles;
    // index of the last inserted document
    private int docIDCounter = 0;

    public DocumentSimilarity(String path){
        tstTree = new TST<>();
        numberOfFiles = Objects.requireNonNull(new File(path).listFiles()).length;
        readFilesAndMakeTrigrams(path);
    }

    /**
     * macht aus jedem wort ein Trigram
     * @param word String of inserting Word
     * @return list of trigrams of the word
     */
    private List<String> createTrigrams(String word){
        List<String> trigrams = new ArrayList<>();
        //Ein Trigramm ist eine Folge von 3 Zeichen
        int THREGRAM_SIZE = 3;
        if(word.length() < THREGRAM_SIZE){
            return trigrams;
        }
        //make Trigram
        trigrams.add(word.substring(0, THREGRAM_SIZE));
        //recursive call with word - first character
        trigrams.addAll(createTrigrams(word.substring(1)));
        return trigrams;
    }

    /**
     * fills the TST with all file in the directory pathToFiles
     * @param pathToFiles path of the files
     */
    private void readFilesAndMakeTrigrams(String pathToFiles){
        for(File file : Objects.requireNonNull(new File(pathToFiles).listFiles())){
            System.out.println(docIDCounter +"\t"+file.getName());
            List<String> words = new ArrayList<>();
            try {
                for(String line : Files.readAllLines(file.toPath())){
                    //bei allen Satzzeichen trennen
                    words.addAll(Arrays.asList(line.split("\\s")));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            makeTrigrams(words);
            docIDCounter++;
        }
    }

    private void makeTrigrams(List<String> words){
        for(String word: words){
            List<String> trigrams = createTrigrams(word);
            int finalDocumentIndex = docIDCounter;
            trigrams.forEach(trigram -> {
                if(!tstTree.contains(trigram)){
                    tstTree.put(trigram,new int[numberOfFiles]);
                }
                tstTree.get(trigram)[finalDocumentIndex]++;
            });
        }
    }

    /**
     * the distances between all documents in the tst to the console
     */
    private void printErgs(){
        for(int i = 0; i < numberOfFiles; i++){
            for (int j = i+1; j < numberOfFiles; j++){
                System.out.println(i+" <--> "+j+": "+ getDistance(i,j));
            }
        }
    }

    /**
     *
     * @param documentNumberA index of document a
     * @param documentNumberB index of document b
     * @return distance between documentNumberA and documentNumberB
     */
    private double getDistance(int documentNumberA, int documentNumberB){
        int distance = 0;
        for(String trigram : tstTree.keys()){
            distance += Math.pow(tstTree.get(trigram)[documentNumberA] - tstTree.get(trigram)[documentNumberB],2);
        }
        return Math.sqrt(distance);
    }

    public static void main(String[] args) {
        //daten einlesen und verarbeiten
        DocumentSimilarity ds = new DocumentSimilarity("./data/");
        //ergebnisse errechnen und ausgeben
        ds.printErgs();
    }
}
