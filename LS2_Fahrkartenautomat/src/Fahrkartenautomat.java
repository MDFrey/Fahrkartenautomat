//A3.3 ist implementiert
//A3.4 ist implementiert
//A3.5 ist implementiert
//A4.4 ist implementiert
//A4.6 ist implementiert
//A6.2.1 ist implementiert
//A6.2.2 ist implementiert
//A6.2.3 ist implementiert
//A6.2.4 ist implementiert
//A6.2.5 ist implementiert
//A6.3 ist implementiert

import java.util.Scanner;

class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);
		double rueckgabebetrag;
		
		//A6.2.1
		Begruessung();
		
		//A6.2.2
		double zuZahlenderBetrag = FahrkartenbestellungErfassen(tastatur);
		//A6.2.3
		double eingezahlterGesamtbetrag = Bezahlung(tastatur, zuZahlenderBetrag);
		
		//A6.2.4
		Fahrkartenausgabe();
		
		//Rückgeldberechnung
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		rueckgabebetrag = Math.round(rueckgabebetrag * 100) / 100.0;
		
		//A6.2.5
		Rueckgeldausgabe(rueckgabebetrag);
		
		
		
		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

		tastatur.close();
	}
	
	public static void Begruessung() {
		System.out.println("Herzlich Wilkkommen!");
		System.out.println();
	}
	
	public static double FahrkartenbestellungErfassen(Scanner tastatur) {
		double zuZahlenderBetrag;
		
		// Geldbetrag eingeben
		System.out.print("Zu zahlender Betrag (Euro): ");
		zuZahlenderBetrag = tastatur.nextDouble();
		if(zuZahlenderBetrag < 0 || zuZahlenderBetrag > 10) {
			zuZahlenderBetrag = 1;
			System.out.println("Fehlerhafte Eingabe - Ticketpreis wird auf 1 gesetzt!");
		}
		
		// Anzahl der Farkarten eingebn
		System.out.print("Anzahl der Fahrkarten: ");
		byte anzahlFahrkarten = tastatur.nextByte();
		if(anzahlFahrkarten < 0 || anzahlFahrkarten > 10) {
			anzahlFahrkarten = 1;
			System.out.println("Fehlerhafte Eingabe - Anzahl der Tickets wird auf 1 gesetzt!");
		}
		System.out.println();
		
		//neuer zu zahlender Betrag
		zuZahlenderBetrag = zuZahlenderBetrag * anzahlFahrkarten;
		
	
		return zuZahlenderBetrag;
	}
	
	public static double Bezahlung(Scanner tastatur, double zuZahlenderBetrag) {
		double nochZuZahlen;
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		
		// Geldeinwurf
		eingezahlterGesamtbetrag = 0.0;
		nochZuZahlen = 0.0;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %.2f Euro \n", nochZuZahlen);
			System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro-Schein): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			if(eingeworfeneMuenze == 0.05 || eingeworfeneMuenze == 0.10 || eingeworfeneMuenze == 0.20 || eingeworfeneMuenze == 0.50 || eingeworfeneMuenze == 1 || eingeworfeneMuenze == 2 || eingeworfeneMuenze == 5 || eingeworfeneMuenze == 10 || eingeworfeneMuenze == 20) {
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
			}else {
				System.out.println(">> Kein gueltiges Zahlungsmittel!");
			}
		}
		
		return eingezahlterGesamtbetrag;
	}
	
	public static void Fahrkartenausgabe() {
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
	}
	
	public static void Rueckgeldausgabe(double rueckgabebetrag) {	
		
		//Ausgabe
		if (rueckgabebetrag > 0.0) {
			System.out.printf("Der Rückgabebetrag in Höhe von: %.2f Euro ", rueckgabebetrag);
			System.out.println("wird in folgenden Münzen ausgezahlt:");
			
			rueckgabebetrag = Rueckgeldberechnung(2.0, rueckgabebetrag, "2 Euro"); //2-Euro-Münzen
			rueckgabebetrag = Rueckgeldberechnung(1.0, rueckgabebetrag, "1 Euro"); //1-Euro-Münzen
			rueckgabebetrag = Rueckgeldberechnung(0.5, rueckgabebetrag, "50 Cent"); //50-Cent-Münzen
			rueckgabebetrag = Rueckgeldberechnung(0.2, rueckgabebetrag, "20 Cent"); //20-Cent-Münzen
			rueckgabebetrag = Rueckgeldberechnung(0.1, rueckgabebetrag, "10 Cent"); //10-Cent-Münzen
			rueckgabebetrag = Rueckgeldberechnung(0.05, rueckgabebetrag, "5 Cent"); //5-Cent-Münzen
		}
	}
	
	//A6.3
	public static double Rueckgeldberechnung(double münzwert, double rueckgabebetrag, String rückgabe) {
		while (rueckgabebetrag >= münzwert) {
			System.out.println(rückgabe);
			rueckgabebetrag = rueckgabebetrag - münzwert;
			rueckgabebetrag = Math.round(rueckgabebetrag * 100) / 100.0;
		}
		return rueckgabebetrag;
	}
}