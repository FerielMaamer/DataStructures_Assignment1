import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //first load all known words from the text file “wordlist.txt” into the dictionary class
        Dictionary dc = new Dictionary();
        dc.loadFromFile("src/wordList.txt");

        displayMenu();
        int menuIndex = Integer.parseInt(input.nextLine());
        while (menuIndex != 6) {
            if(menuIndex==1) {
                System.out.println("What is the word?\n");
                String word = input.nextLine();
                System.out.println("What is the meaning of the word?\n");
                String meaning = input.nextLine();
                boolean wasAdded = dc.add(word, meaning);
                if (wasAdded){System.out.println("The word was successfully added");}
                else{System.out.println("The word could not be added");}
                displayMenu();
                menuIndex = Integer.parseInt(input.nextLine());
            }
            if(menuIndex==2) {
                System.out.println("What is the word to delete?\n");
                String wordDelete = input.nextLine();
                boolean wasDeleted = dc.delete(wordDelete);
                if (wasDeleted){System.out.println("The word was successfully deleted");}
                else{System.out.println("The word could not be deleted");}
                displayMenu();
                menuIndex = Integer.parseInt(input.nextLine());
            }
            if (menuIndex==3) {
                System.out.println("Which word would you like to get the meaning of?\n");
                String wordMeaning = input.nextLine();
                System.out.println(dc.getMeaning(wordMeaning));
                displayMenu();
                menuIndex = Integer.parseInt(input.nextLine());
            }
            if (menuIndex==4) {
                System.out.println(dc.printWordList());
                displayMenu();
                menuIndex = Integer.parseInt(input.nextLine());
            }
            if (menuIndex==5) {
                System.out.println("Enter the file path");
                String filePath = input.nextLine();
                dc.textFileSpellCheck(filePath);
                displayMenu();
                menuIndex = Integer.parseInt(input.nextLine());
            }
            if (menuIndex==6)
                    break;
            else{
                System.out.println("You did not enter a correct value, please choose the right number or exit with 6");
                displayMenu();
                menuIndex = Integer.parseInt(input.nextLine());
            }
        }
    }
    public static void displayMenu(){
        System.out.println("\nPlease choose and option from the menu below");
        System.out.println(
                "1:Add new word \n" +
                        "2:Delete word \n"+
                        "3:Get meaning \n"+
                        "4:Dictionary list \n"+
                        "5:Spell check a text file \n"+
                        "6:Exit \n"
        );
    }

}