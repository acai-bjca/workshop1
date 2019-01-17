import java.util.Scanner;

public class ReadLines {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String line = "";
		int count = 0;
		while (scan.hasNext()) {
			line = scan.nextLine();
			count += 1;
			System.out.println(count+" "+line);
		}
		
		scan.close();
	}

}
