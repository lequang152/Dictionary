import java.util.ArrayList;
import java.lang.String;
import java.util.Scanner;

public class DictionaryCommandline {
    public void showAllWords() {
        ArrayList<Word> wordsList = Dictionary.words;
        System.out.format("%-5s %-30s %-50s\n", "No", "|English", "|Vietnamese");
        for(int i = 0; i < wordsList.size(); i++) {
            System.out.format("%-5s %-30s %-50s\n", i + 1, "|" + wordsList.get(i).getWord_target(), "|" + wordsList.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        DictionaryManagement.InsertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        DictionaryManagement.insertFromDatabase("av");
        //showAllWords();
        //dictionarySearcher();
    }

    public static void dictionarySearcher() {
        System.out.println("Nhập từ cần tra cứu: ");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();
        ArrayList<Word> wordsList = Dictionary.words;
        int k = 1;
        System.out.format("%-5s %-30s %-50s\n", "No", "|English", "|Vietnamese");
        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i).getWord_target().contains(search)) {
                System.out.format("%-5s %-30s %-50s\n", k, "|" + wordsList.get(i).getWord_target(), "|" + wordsList.get(i).getWord_explain());
                k++;
            }
        }
    }
}
