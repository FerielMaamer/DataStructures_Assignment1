import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //first load all known words from the text file “wordlist.txt” into the dictionary class
        Dictionary dc = new Dictionary();
        dc.loadFromFile("src/wordList.txt");
        //System.out.println(dc.printWordList());
        //dc.printDictionary();
        //dc.textFileSpellCheck("src/test.txt");
        System.out.println(dc.add("monster", "a big creature"));
        dc.printDictionary();
        System.out.println(dc.delete("monster"));
        System.out.println(dc.getMeaning("monster"));
        System.out.println(dc.getIndex("your"));
//        Create a main program with the following menu options:
//        1: Add new word
//        2: Delete word
//        3: Get meaning
//        4: Dictionary list
//        5: Spell check a text file.
//        6: Exit
//        System.out.println(
//                "1:Add new word \n" +
//                "2:Delete word \n"+
//                "3:Get meaning \n"+
//                "4:Dictionary list \n"+
//                "5:Spell check a text file \n"+
//                "6:Exit \n"
//        );
//        int menuIndex = Integer.parseInt(input.nextLine());
//        switch(menuIndex) {
//            case 1:
//                System.out.println("What is the word?\n");
//                String word = input.nextLine();
//                System.out.println("What is the meaning of the word?\n");
//                String meaning = input.nextLine();
//                dc.add(word,meaning);
//                break;
//            case 2:
//                System.out.println("What is the word to delete?\n");
//                String wordDelete = input.nextLine();
//                dc.delete(wordDelete);
//                break;
//            case 3:
//                System.out.println("Which word would you like to get the meaning of?\n");
//                String wordMeaning = input.nextLine();
//                dc.getMeaning(wordMeaning);
//                break;
//            case 4:
//                dc.printWordList();
//                break;
//            case 5:
//                // code block
//                break;
//            case 6:
//                break;
//            default:
//                System.out.println("You did not enter a correct value");
//                break;
//        }

    }

}