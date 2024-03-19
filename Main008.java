//Letter and character count. 
// Program Specifications
// Design a program that allows users to input the string value. Count and display the number of letters and characters



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main008 {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // String sentence = "This is a sample sentence, with some special characters
        // like !@#$%^&*()_-+=[]{};:'\"\\|/?.,<> and also a date 11/01/1111.";

        // String sentence2 = "Hello world 06/06/2023";
        String sentence = checkInputString();

        String[] words = getWords(sentence);
        Map<String, Integer> wordFreqs = getWordFrequencies(words);
        printFrequencies(wordFreqs, "Word frequency:");

        Map<Character, Integer> charFreqs = getCharacterFrequencies(sentence);
        printFrequencies(charFreqs, "Character frequency:");
    }

    // kiem tra user input co empty hay ko
    public static String checkInputString() {
        // loop until user input true value
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public static String[] getWords(String sentence) {
        // Tìm và loại bỏ ngày trong định dạng dd/mm/yyyy
        // String pattern = "\\b(0?[1-9]|[12]\\d|3[01])/(0?[1-9]|1[0-2])/\\d{4}\\b";
        // sentence = sentence.replaceAll(pattern, ""); -- khong can thiet

        // Loại bỏ các kí tự đặc biệt và tách câu thành các từ
        sentence = sentence.replaceAll("[^a-zA-Z0-9]", " ");
        String[] words = sentence.split("\\s+");
        return words;
    }

    public static Map<String, Integer> getWordFrequencies(String[] words) {
        // Tính tần suất xuất hiện của các từ
        Map<String, Integer> wordFreqs = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            int freq = wordFreqs.getOrDefault(word, 0);
            wordFreqs.put(word, freq + 1);
        }
        return wordFreqs;
    }

    public static Map<Character, Integer> getCharacterFrequencies(String sentence) {
        // Tính tần suất xuất hiện của các chữ cái
        Map<Character, Integer> charFreqs = new HashMap<>();
        for (char c : sentence.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                c = Character.toLowerCase(c);
                int freq = charFreqs.getOrDefault(c, 0);
                charFreqs.put(c, freq + 1);
            }
        }
        return charFreqs;
    }

    public static <K, V> void printFrequencies(Map<K, V> freqs, String title) {
        System.out.println(title);
        System.out.println(freqs.toString());
    }
}
