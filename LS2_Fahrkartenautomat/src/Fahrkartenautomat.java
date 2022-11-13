//A3.3 ist implementiert
//A3.4 ist implementiert
//A3.5 ist implementiert

import java.util.Scanner;

class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		double zuZahlenderBetrag;
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		double rueckgabebetrag;
		double nochZuZahlen;

		// Geldbetrag eingeben
		System.out.print("Zu zahlender Betrag (Euro): ");
		zuZahlenderBetrag = tastatur.nextDouble();
		
		// Anzahl der Farkarten eingebn
		System.out.print("Anzahl der Fahrkarten: ");
		byte anzahlFahrkarten = tastatur.nextByte();
		
		//neuer zu zahlender Betrag
		zuZahlenderBetrag = zuZahlenderBetrag * anzahlFahrkarten;

		// Geldeinwurf
		eingezahlterGesamtbetrag = 0.0;
		nochZuZahlen = 0.0;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %.2f Euro \n", nochZuZahlen);
			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
		
		// Fahrscheinausgabe
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");
		
		// Rückgelberechnung und Ausgabe
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		rueckgabebetrag = Math.round(rueckgabebetrag * 100) / 100.0;
		
		if (rueckgabebetrag > 0.0) {
			System.out.printf("Der Rückgabebetrag in Höhe von: %.2f Euro ", rueckgabebetrag);
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100) / 100.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100) / 100.0;
			}
			while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100) / 100.0;
			}
			while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100) / 100.0;
			}
			while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100) / 100.0;
			}
			while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.05;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100) / 100.0;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

		tastatur.close();
	}
}