import java.util.*;
/**
*
* @author Anderas Pichler
* Notizbuch Klasse mit Methoden zum erstellen bzw suchen
*
*/
public class Notizbuch {

	private ArrayList<Note> notes;
	private ArrayList<Verfasser> authors;
	public Notizbuch() {
		notes=new ArrayList<>();
		authors=new ArrayList<>();
		authors.add(new Verfasser(1, "Andreas", "Pichler"));
		authors.add(new Verfasser(2, "Peter", "Leuprecht"));
		authors.add(new Verfasser(3, "EvaMaria", "Hauser"));
	}
	public void notizAufnehmen(Verfasser verfasser, int notizNr, String text, boolean erledigt) {
		int nr=notizNr;
		if(notizMitNummerVorhanden(notizNr)) {
			nr=hoechsteNotizummer()+1;
		}
		notes.add(new Note(verfasser, nr, text, erledigt));
	}
	public Note gibNotizMitNummer(int notizNr) {
		Note notiz=null;
		for(Note notizen : notes) {
			if(notizen.getNotizNr()==notizNr) {
				notiz=notizen;
			}
		}
		return notiz;
	}
	public int anzahlNotizen() {

		return notes.size();
	}
	public int anzahlNotizenVonVerfasserNr(int verfasserNr) {
		int nr=0;
		for(Note notiz:notes) {
			if(notiz.getVerfasser().getVerfasserNr()==verfasserNr) {
				nr++;
			}
		}
		return nr;
	}
	public int anzahlNotizenVonVerfasserNr(Verfasser verfasser) {
		int nr=0;
		for(Note notiz:notes) {
			if(notiz.getVerfasser().getVerfasserNr()==verfasser.getVerfasserNr()) {
				nr++;
			}
		}
		return nr;
	}

	public ArrayList<Note> gibNotizenVonVerfasser(Verfasser verfasser){
		ArrayList<Note> liste = new ArrayList<>();
		for(Note notiz : notes) {
			if(notiz.getVerfasser().getVerfasserNr()==verfasser.getVerfasserNr()) {
				liste.add(notiz);

			}
		}
		return liste;
	}

	public ArrayList<Note> gibNotizenMitTextinhalt(String text){
		ArrayList<Note> liste = new ArrayList<>();
		for(Note notiz : notes) {
			if(notiz.getNotiztext().contains(text)) {
				liste.add(notiz);

			}
		}
		return liste;
	}

	public void notizaendernMitNummer (int notizNr, String newText) {
		for(Note notiz : notes) {
			if(notiz.getNotizNr()==notizNr) {
				notiz.setNotiztext(newText);
			}
		}
	}
	public void notizLoeschenAufPosition(int index) {
		notes.remove(index);
	}
	public void notizLoeschenMitNummer(int notizNr) {
		Iterator<Note> it=notes.iterator();
		while(it.hasNext()) {
			Note notiz=it.next();
			if(notiz.getNotizNr()==notizNr) {
				it.remove();
			}
		}
	}
	public void notizenLoeschenDerVerfasserNr(int verfasserNr) {
		Iterator<Note> it=notes.iterator();
		while(it.hasNext()) {
			Note notiz=it.next();
			if(notiz.getVerfasser().getVerfasserNr()==verfasserNr) {
				it.remove();
			}
		}
	}
	public void notizenLoeschenDerVerfasserNr(Verfasser verfasser) {
		Iterator<Note> it=notes.iterator();
		while(it.hasNext()) {
			Note notiz=it.next();
			if(notiz.getVerfasser().getVerfasserNr()==verfasser.getVerfasserNr()) {
				it.remove();
			}
		}
	}
	public Verfasser logIn(String firstname) {
		for(Verfasser verfasser : authors) {
			if(verfasser.getVorname().equals(firstname)) {
				return verfasser;
			}
		}
		return null;
	}

	public void signUp(int verfasserNr, String vorname, String nachname) {
		int nr=0;
		if(verfasserNrvorhanden(verfasserNr)) {
			nr=hoechsteVerfasserNr()+1;
		}
		else {
			nr=verfasserNr;
		}
		authors.add(new Verfasser(nr, vorname, nachname));
	}

	private int hoechsteVerfasserNr() {
		int nr=0;
		for(Verfasser verfasser : authors) {
			if(verfasser.getVerfasserNr()>nr) {
				nr=verfasser.getVerfasserNr();
			}
		}
		return nr;
	}

	private boolean verfasserNrvorhanden(int verfasserNr) {

		for(Verfasser verfasser: authors) {
			if(verfasser.getVerfasserNr()==verfasserNr) {
				return true;
			}
		}
		return false;
	}
	private int hoechsteNotizummer() {
		int nr=0;
		for(Note notiz : notes) {
			if(notiz.getNotizNr()>nr) {
				nr=notiz.getNotizNr();
			}
		}
		return nr;
	}
	private boolean notizMitNummerVorhanden(int notizNr) {
		boolean vorhanden=false;
		for(Note notiz : notes) {
			if(notiz.getNotizNr()==notizNr) {
				vorhanden=true;
			}
		}
		return vorhanden;
	}
}
