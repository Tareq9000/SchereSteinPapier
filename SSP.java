import java.util.Scanner;
import java.util.Random;

public class SSP {
	Scanner scan = new Scanner(System.in);
	Random zufall = new Random();

	public static void main(String[] args) {
		SSP program = new SSP();
		program.run();

	}

	char sp = ' ';
	char pc = ' ';
	int punktsp = 0;
	int punktpc = 0;

	char nochmal = '0';

	public void run() {

		System.out.println("SCHERE STEIN PAPIER");
		do {
			System.out.println("------------------------------------------------------------------");

			do {

				do {
					System.out.println("Gib ein (schere = x, stein = o, papier = -) >");
					sp = scan.next().charAt(0);
				} while (sp != 'x' && sp != 'o' && sp != '-');

				computer();
				vergleichGewinner();

			} while (punktpc < 3 && punktsp < 3);

			if (punktpc == 3) {
				System.out.println("-----------------------------");
				System.out.println("Der PC hat das Match gewonnen");
				System.out.println("-----------------------------");
			} else if (punktsp == 3) {
				System.out.println("----------------------------------");
				System.out.println("Der Spieler hat das Match gewonnen");
				System.out.println("----------------------------------");
			}
			System.out.println("Nochmal spielen? (y / n) >");
			nochmal = scan.next().charAt(0);

		} while (nochmal == 'y');
	}

	public void computer() {

		int zufallsZahl = zufall.nextInt(3);

		if (zufallsZahl == 0) {
			System.out.println("x");
			pc = 'x';
		} else if (zufallsZahl == 1) {
			System.out.println("o");
			pc = 'o';
		} else {
			System.out.println("-");
			pc = '-';
		}

	}

	public void vergleichGewinner() {

		if (pc == 'x' && sp == 'o') {
			System.out.println("Spieler gewinnt");
			punktsp++;
		} else if (pc == 'x' && sp == '-') {
			System.out.println("PC gewinnt");
			punktpc++;
		} else if (pc == 'o' && sp == 'x') {
			System.out.println("PC gewinnt");
			punktpc++;
		} else if (pc == 'o' && sp == '-') {
			System.out.println("Spieler gewinnt");
			punktsp++;
		} else if (pc == '-' && sp == 'x') {
			System.out.println("Spieler gewinnt");
			punktsp++;
		} else if (pc == '-' && sp == 'o') {
			System.out.println("PC gewinnt");
			punktpc++;
		} else {
			System.out.println("unendschieden");
		}

	}

}