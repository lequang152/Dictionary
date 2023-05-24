import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.IOException;
import java.nio.file.Path;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class DictionaryManagement {
    public static void InsertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số từ cần thêm: ");
        int nums;
        nums = sc.nextInt();
        String a;
        a = sc.nextLine();
        for (int i = 0; i < nums; i++) {
            System.out.println("Nhập từ cần thêm: ");
            String target = sc.nextLine();
            System.out.println("Nhập nghĩa của từ: ");
            String explain = sc.nextLine();
            Word word = new Word(target, explain);
            Dictionary.words.add(word);
            System.out.println("Thêm từ thành công!");
        }
    }

    public static void insertFromFile() {
        try {
            Path path = Paths.get("Dictionary.txt");
            List<String> f = Files.readAllLines(path);
            for (String list : f) {
                String[] data = list.split("\t");
                Word word = new Word();
                word.setWord_target(data[0]);
                word.setWord_explain(data[1]);
                Dictionary.words.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dictionaryLookup() {
        System.out.println("Nhập từ cần tìm kiếm: ");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();
        ArrayList<Word> wordsList = Dictionary.words;
        System.out.format("%-5s %-30s %-50s\n", "No", "|English", "|Vietnamese");
        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i).getWord_target().equals(search)) {
                System.out.format("%-5s %-30s %-50s\n", i + 1, "|" + wordsList.get(i).getWord_target(), "|" + wordsList.get(i).getWord_explain());
            }
        }
    }

    public static void dictionaryExportToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Dictionary.txt"));
            for (int i = 0; i < Dictionary.words.size(); i++) {
                bw.write(Dictionary.words.get(i).getWord_target() + "\t" + Dictionary.words.get(i).getWord_explain() + "\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateDictionary() {
        System.out.println("Bạn muốn: (Chọn số 1-3)");
        System.out.format("%-15s %-15s %-15s\n",
                "1-Sửa từ",
                "2-Thêm từ",
                "3-Xóa từ");
        String upd;
        Scanner sc = new Scanner(System.in);
        upd = sc.nextLine();
        if (upd.equals("2")) {
            InsertFromCommandline();
        }
        if (upd.equals("3")) {
            deleteWord();
        }
    }

    public static void deleteWord() {
        boolean th = false;
        System.out.println("Nhập từ cần xóa: ");
        Scanner sc = new Scanner(System.in);
        String del;
        del = sc.nextLine();
        for (int i = 0; i < Dictionary.words.size(); i++) {
            if (Dictionary.words.get(i).getWord_target().equals(del)) {
                Dictionary.words.remove(i);
                System.out.println("Xóa từ thành công!");
                th = true;
            }
        }
        if (!th) {
            System.out.println("Không tìm thấy từ để xóa!");
        }
    }

    public void speak(String text) {
        TextToSpeech speech = new TextToSpeech(text);
        speech.speakText();
    }

    public static void speakWord_target(int i) {
        TextToSpeech speech = new TextToSpeech(Dictionary.words.get(i).getWord_target());
        speech.speakText();
    }

    /*
    public static void speakWord_explain(int i) {
        TextToSpeech speech = new TextToSpeech(Dictionary.words.get(i).getWord_explain());
        speech.speakText();
    }
    */

    public static void speakWord_explain(int i) {
        String s = Dictionary.words.get(i).getWord_explain();;
        if(s.contains("<i>")) {
            s = s.substring(s.indexOf(">") + 1);
            s = s.substring(0, s.indexOf("<"));
        }
        else {
            s = s.replaceAll("excl: ", "");
            s = s.replaceAll("verb: ", "");
            s = s.replaceAll("noun: ", "");
            s = s.replaceAll("adj: ", "");
            s = s.replaceAll("verb: ", "");
            s = s.replaceAll("adjective: ", "");
        }
        TextToSpeech speech = new TextToSpeech(s);
        speech.speakText();
    }

    public static void insertFromDatabase(String table_name) {
        SQLiteJDBC sqlite = new SQLiteJDBC();
        sqlite.readDatabase(table_name);
    }

    public static void dictionaryExportToDatabase(String table_name) {
        SQLiteJDBC sqlite = new SQLiteJDBC();
        sqlite.overwriteDatabase(table_name);
    }
}
