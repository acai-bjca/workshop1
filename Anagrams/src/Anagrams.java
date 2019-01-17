
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Anagrams {
	
	public static HashMap<Character, Integer> countWords(ArrayList<Character> word1) {
		HashMap<Character, Integer> words1= new HashMap<>();
		for (int i = 0; i<word1.size(); i++) {
			if (words1.containsKey(word1.get(i))) words1.replace(word1.get(i), words1.get(word1.get(i))+1);
			else words1.put(word1.get(i), 1);
		}
		return words1;
	}
	
	public static ArrayList<Character> separateWords(String w) {
		ArrayList<Character> words = new ArrayList<>();
		for (int i = 0; i<w.length(); i++) {
			words.add(w.charAt(i));
		}
		return words;
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
        String word1 = scan.next();
        String word2 = scan.next();
        scan.close();
		String answer = "Not Anagrams";	
		ArrayList<Character> w1 = separateWords(word1.toLowerCase());
		w1.sort(null);
		ArrayList<Character> w2 = separateWords(word2.toLowerCase());
		w2.sort(null);
		if (word1.length() == word2.length()) {
			HashMap<Character, Integer> words1 = countWords(w1);
			HashMap<Character, Integer> words2 = countWords(w2);
			if (words1.equals(words2)) answer = "Anagrams";
		}
		System.out.println(answer);		
	}

}
