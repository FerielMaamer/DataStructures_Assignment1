import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Dictionary {
    WordInfo [] dictionary;
    int numWords;
    int maxNumWords;

    public Dictionary() {
        numWords = 0;
        maxNumWords = 1500;
        dictionary = new WordInfo[maxNumWords];
    }

    public boolean loadFromFile(String filePath){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                WordInfo newWord = new WordInfo(line, "Undefined word");
                dictionary[numWords]=newWord;
                numWords++;
                // read next line
                line = reader.readLine();
            }
            reader.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean exists(String word){
        int low=0;
        int high=numWords;
        while(low<=high){
            int mid = (low+high)/2;
            if (dictionary[mid].word.compareTo(word) == 0){
                return true;
            }else if (dictionary[mid].word.compareTo(word)>0){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
    public int getIndex(String word){
        int low=0;
        int high=numWords;
        while(low<=high){
            int mid = (low+high)/2;
            if (dictionary[mid].word.compareTo(word) == 0){
                return mid;
            }else if (dictionary[mid].word.compareTo(word)>0){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }

    public boolean add (String word, String meaning){
        //int index= getIndex(word);
        if (!exists(word) && numWords<=maxNumWords){
            //creating the new object
            WordInfo newWord = new WordInfo(word.toLowerCase(), meaning);
            //using insertion sort to order the list before adding the object
            int prepos = numWords-1;
            while(prepos>=0 && dictionary[prepos].word.toLowerCase().compareTo(word)>0){
                dictionary[prepos+1]=dictionary[prepos];
                prepos--;
            }
            //adding the object at the right spot
            dictionary[prepos+1]=newWord;
            numWords++;
            return true;
        }else{
            return false;
        }
    }

    public boolean delete (String word){
        int index=getIndex(word);
        if(index!=-1){
            for (int i = index; i<numWords; i++ ){
                dictionary[index]=dictionary[index+1];
            }
            numWords--;
            return true;
        }
        return false;
    }

    public String getMeaning(String word){
        int index=getIndex(word);
        if(index!=-1){
            return dictionary[index].meaning;
        }
        return "Word not Found";
    }

    public int getCount(){
        int count = 0;
        for (int i=0; i<numWords; i++){
            if (dictionary[i]!=null){
                count++;
            }
        }
        return count;
    }

    public void textFileSpellCheck(String filePath){
        //String [] newWords= new String[];
        try{
            File file = new File(filePath);
            Scanner input = new Scanner(file);
//replaceAll("[.,]*", "")
            while (input.hasNext()) {
                boolean exists= false;
                String [] word  = input.nextLine().split("[.,\\s]");
                for (String w : word){
                    if (!w.equals("") && !exists(w)){
                        System.out.println(w);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String printWordList(){
        String wordList = "";
        for (int i=0; i<numWords; i++){
            wordList+= dictionary[i].word + ",\n";
        }
        return wordList;
    }
    public void printDictionary(){
        for (int i=0; i<numWords; i++){
            System.out.println(dictionary[i]);
        }
    }

}
