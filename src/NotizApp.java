import java.util.*;
/**
* @author Andreas Pichler
* Dies ist die App zum Notizbuch mit Anmeldung
*
*/
public class NotizApp {

	public static Scanner scan=new Scanner(System.in);

	public static Verfasser loginVerfasser=null;

	public static String loginName;

	public static Notizbuch notizbuch=new Notizbuch();

	public static void main(String[] args) {

		boolean a=true;
		boolean b=false;


		System.out.println("Hallo und Willkommen!!!!");

		while(a==true) {


			System.out.println("Was wollen Sie machen, tippen Sie ein: `signIn`? falls Sie noch kein Konto haben bitte geben Sie `signUp` ein.  oder `exit` zum beenden:  ");
			loginName=scan.nextLine();

			if(loginName.equals("signUp")) {

				System.out.println("Um einen neuen Verfasser zu erstellen, bitte Geben Sie VerfasserNr, Vorname und Nachname ein. \nNr: ");
				int verfasserNr=scan.nextInt();
				scan.nextLine();
				System.out.println("Vorname: ");
				String vorname =scan.nextLine();
				System.out.println("Nachname: ");
				String nachname=scan.nextLine();
				notizbuch.signUp(verfasserNr, vorname, nachname);
				loginVerfasser=notizbuch.logIn(vorname);
				b=true;
			}
			if(loginName.equals("exit")) {
				b=false;
				a=false;
				break;
			}
			if(loginName.equals("signIn")) {


				System.out.println("Geben Sie Ihren Vorname an: ");

				String firstname=scan.nextLine();
				loginVerfasser=notizbuch.logIn(firstname);
				if(loginVerfasser==null) {
					b=false;
				}
				else {
					b=true;
				}
			}
			if(!loginName.equals("signUp") && !loginName.equals("exit") && !loginName.equals("signIn")) {

				System.out.println("Hoppla es ist etwas schief gelaufen!! ");
			}
			while(b==true) {

				System.out.println("Waehlen Sie Ihre Obtion: \n1: Notiz Verfassen \n2: Gibt Notiz mit Nummer \n3: Anzahl der Notizen \n4: Gibt Anzahl aller eingetragene Notzen von Verfasser Nummer "
						+ "\n5: Gibt Notizen von Verfasser \n6: Gibt die Notiz, die Text enth�lt \n7: Aendert Text mit angegebener NotizNr \n8: Loeschen auf Position  \n9: Notiz loeschen mit Nummer "
						+ "\n10: Notiz loeschen mit Verfasser Nummer \n11: Logout ");
				int number=scan.nextInt();
				scan.nextLine();
				switch(number) {
				case 1: {
					neueNotiz();
					break;
				}
				case 2: {
					gibtNotizMitNummer();
					break;
				}

				case 3: {
					 anzahlderNotizen();
					 break;
				}
				case 4: {
					anzahlderNotizenvonVefasser();
					break;
				}
				case 5: {
					gibtNotizenvonVerfasser();
					break;
				}
				case 6: {
					gibtNotizMitTextInhalt();
					break;

				}
				case 7: {
					aendernVonTextMitNummer();
					break;
				}
				case 8: {
					loeschenAufposition();
					break;
				}
				case 9: {
					notizLoeschenMitNummer();
					break;
				}
				case 10: {
					notizLoeschenMitVerfasserNr();
					break;
				}
				case 11: {
					b=false;
					break;
				}
				default : {
					System.out.println("return");
					break;
				}

				}
			}
		}

		System.out.println("Und Tschuesssssssss......");
	}
	/**
	* Methode zur Andmeldung
	*
	*/
	public static void neueNotiz() {
		System.out.println("NotizNr: ");
		int notizNr=scan.nextInt();
		scan.nextLine();
		System.out.println("Text: ");
		String text =scan.nextLine();
		System.out.println("Erledigt? (true oder false) ");
		boolean erledigt = scan.nextBoolean();
		notizbuch.notizAufnehmen(loginVerfasser, notizNr, text, erledigt);

	}
	/**
	* Gibt notizen mit Notiznummer
	*
	*/
	public static void gibtNotizMitNummer() {
		System.out.println("Geben Sie die Nummer An: ");
		int nr=scan.nextInt();
		scan.nextLine();
		Note notiz=notizbuch.gibNotizMitNummer(nr);
			System.out.println("Author: " + notiz.getVerfasser().getVorname() + "\nNotizNr: " + notiz.getNotizNr() + "\nNotizText: " + notiz.getNotiztext() + "\nErledigt: " + notiz.isErledigt() + "\n\n");
	}
	/**
	* Anzahl der Notizen
	*
	*/
	public static void anzahlderNotizen() {
		int anzahl=notizbuch.anzahlNotizen();

		System.out.println("Anzahl aller Notizen: " + anzahl + "\n\n");
	}
	/**
	* Aendert die Notiz des Verfassers
	*
	*/
	public static void anzahlderNotizenvonVefasser() {

		System.out.println("Bitte geben Sie die Nummer ein von Verfasser, die Sie angezeigt bekommen m�chten oder tippe 0 f�r alle ausgeben mit aktuellen Verfasser: ");
		int nr=scan.nextInt();
		scan.nextLine();
		int anzahl =0;
		if(nr>0) {
			anzahl=notizbuch.anzahlNotizenVonVerfasserNr(nr);
			System.out.println("Notizen Anzahl: " + anzahl + "\n\n");
		}
		else {
			anzahl=notizbuch.anzahlNotizenVonVerfasserNr(loginVerfasser);
			System.out.println("Notizen Anzahl: " + anzahl + "\n\n");
		}
	}
	/**
	* Gibt die Notiz des Verfassers
	*
	*/
	public static void gibtNotizenvonVerfasser() {
		ArrayList<Note> notizen=notizbuch.gibNotizenVonVerfasser(loginVerfasser);
			for(Note list : notizen) {
				System.out.println("NotizNr: " + list.getNotizNr() + "\nText: " + list.getNotiztext() + "\nErledigt: " + list.isErledigt() + "\n\n");
			}

	}
	/**
	* Notiz mit Textinhalt wird ausgegeben
	*
	*/
	public static void gibtNotizMitTextInhalt() {
		System.out.println("Bitte geben Sie ihren Text ein den Sie suchen: ");
		String text=new Scanner(System.in).nextLine();
		ArrayList<Note> notizen=notizbuch.gibNotizenMitTextinhalt(text);
		for(Note list : notizen) {
			System.out.println("NotizNr: " + list.getNotizNr() + "\nText: " + list.getNotiztext() + "\nErledigt: " + list.isErledigt() + "\n\n");
		}
	}
	/**
	* Aendert den Text mit Notiznummer
	*
	*/
	public static void aendernVonTextMitNummer() {

		System.out.println("Geben Sie die Nummer ein und den Text den Sie aendern moechten: \nNr: ");
		int nr=scan.nextInt();
		scan.nextLine();
		System.out.println("Text: ");
		String text=scan.nextLine();

		notizbuch.notizaendernMitNummer(nr, text);


	}
	/**
	*	Loescht aktuelle Notiz
	*
	*/
	public static void loeschenAufposition() {
		System.out.println("Geben Sie die Position ein, die Sie loeschen moechten: ");
		int nr=scan.nextInt();
		scan.nextLine();
		notizbuch.notizLoeschenAufPosition(nr);
	}
	/**
	*	Loescht Notiz mit der Notiznummer
	*
	*/
	public static void notizLoeschenMitNummer() {

		System.out.println("Geben Sie die NotizNr an, die Sie loeschen moechten: ");
		int nr=scan.nextInt();
		scan.nextLine();
		notizbuch.notizLoeschenMitNummer(nr);
	}
	/**
	* Loescht die Notizen von der Verfassernummer S
	*
	*/
	public static void notizLoeschenMitVerfasserNr() {

		System.out.println("Geben Sie die VerfasserNr und loeschen alle Notizen oder tippen Sie 0 zum loeschen Ihrer gesamten notizen ");
		int nr=scan.nextInt();
		scan.nextLine();
		if(nr>0){
			notizbuch.notizenLoeschenDerVerfasserNr(nr);
		}
		else {
			notizbuch.notizenLoeschenDerVerfasserNr(loginVerfasser);
		}
	}
}
