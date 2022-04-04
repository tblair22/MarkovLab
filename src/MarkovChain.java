/*
Trent Blair
4/4/24
this class creates the markov chain using the dictionary class
collaborated with Ishan
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class MarkovChain {
    private Scanner s;
    private File file;
    private String storeFileName;
    private Random r;
    private String words;
    private Dictionary d;
    private int wordsToGenerate;
    private String saveFile;
    String[] wordsArray;

    public MarkovChain(){
        s = new Scanner(System.in);
        System.out.println("Enter the name of the file you want to use ");
        storeFileName = s.nextLine();
        file = new File(storeFileName);
        r = new Random();
        words = "";
        d = new Dictionary();
        System.out.println("Enter the name of the file to store the resorts ");//this will ask the user for the file
        saveFile = s.nextLine();
        System.out.println("How many words ");
        wordsToGenerate = s.nextInt();
        Random r = new Random();

    }


    public boolean readingText(){//reads the text from the source file

        boolean didWork = true;
        try {

            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {

                words += fileReader.nextLine();
                words += " ";
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            didWork = false;
        }

        return didWork;
    }


    public void addDictionary(){

        wordsArray = words.split(" ");

        for(int i = 0;i<wordsArray.length;i++){

            ArrayList<String> values = new ArrayList<String>();
            if(i == wordsArray.length-1){
                d.put(wordsArray[i], values);
            } else if(d.contains(wordsArray[i])){
                ((ArrayList)d.get(wordsArray[i])).add(wordsArray[i+1]);

            } else {
                values.add(wordsArray[i+1]);
                d.put(wordsArray[i], values);
            }
        }

    }


    public String createText(){
        int randomWord = r.nextInt(wordsArray.length);
        String start = wordsArray[randomWord];

        String storeWords = start + " ";

        String keyWords = start;

        for(int i = 0; i<wordsToGenerate-1; i++){
            int val;
            int bound = ((ArrayList)d.get(keyWords)).size();
            val = r.nextInt(bound);
            storeWords += ((ArrayList)d.get(keyWords)).get(val);
            storeWords += " ";
            keyWords = (String)((ArrayList)d.get(keyWords)).get(val);
        }
        try {
            FileWriter myWriter = new FileWriter(saveFile);
            myWriter.write(storeWords);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return storeWords;

    }


}