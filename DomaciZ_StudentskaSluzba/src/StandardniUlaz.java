
import java.util.Scanner;

public class StandardniUlaz {

	static Scanner stUlaz = new Scanner(System.in);
	
	static String prihvatiStringPrekoSUlaza() {
        return stUlaz.nextLine();
    }
	
	static int prihvatiBrojPrekoSUlaza() {
	    return Integer.parseInt(stUlaz.nextLine());
	}
	        
}
