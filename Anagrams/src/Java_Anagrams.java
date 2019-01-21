import java.util.Scanner;

public class Java_Anagrams {
    
	public static String[] separateWords(String w) {
        String[] words = new String[w.length()];
        for (int i = 0; i<w.length(); i++) words[i] = ""+w.charAt(i);
        return words;
    }
    
    public static String[] ordenar(String[] w) {
        String temp = "";
        boolean restart = false;
        int correctPosition = 0, i = 0, j = 0;
        while (i<w.length) {
            for(j = correctPosition; j<w.length && !restart; j++) {
                if (i != j && w[i].compareTo(w[j]) > 0){
                    temp = w[i];
                    w[i] = w[j];
                    w[j] = temp;
                    restart = true;
                }
            }
            if (restart) {
            	restart = false;
                i = correctPosition;
            }
            else {
            	i += 1;
            	if (j==w.length) correctPosition = i;
            }            
        }
        return w;
    }

    public static int coundWords(String letter, String[] word) {
    	int cant = 0;
    	for(int i = 0; i<word.length; i++) {
    		if (word[i].equals(letter)) cant += 1;
    	}
    	return cant;
    }

    public static boolean isAnagram(String a, String b) {
        boolean answer = false;    
        String[] w1 = separateWords(a.toLowerCase());
        w1 = ordenar(w1);
        String[] w2 = separateWords(b.toLowerCase());
        w2 = ordenar(w2);
        if (a.length() == b.length()) {
        	String letter = "";
        	boolean has = true;
        	int cant1 = 0, cant2 = 0;
        	for(int i = 0; i<w1.length && has; i++) {
        		letter = w1[i];
        		cant1 = coundWords(letter, w1);
        		cant2 = coundWords(letter, w2);
        		if (cant1 != cant2) has = false;
        	}
        	if (has) answer = true;
        }        
        return answer;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}