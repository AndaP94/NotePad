/**
* @author Andreas Pichler
* Notiz Klasse
*/
public class Note {

	private Verfasser verfasser;
	private int notizNr;
	private String notiztext;
	private boolean erledigt;



	public Note(Verfasser verfasser, int notizNr, String notiztext, boolean erledigt ) {
		setNotizNr( notizNr);
		setNotiztext(notiztext);
		setVerfasser(verfasser);
		setErledigt( erledigt);

	}

	public Note() {
		this.verfasser=new Verfasser();
		this.notizNr=1;
		this.notiztext="";
		this.erledigt=false;
	}

	public Verfasser getVerfasser() {
		return verfasser;
	}
	public void setVerfasser(Verfasser verfasser) {
		this.verfasser = verfasser;
	}
	public int getNotizNr() {

		return notizNr;
	}
	public void setNotizNr(int notizNr) {
		if(notizNr>0) {
			this.notizNr = notizNr;
		}
		else {
			System.out.println("Bitte geben Sie eine posetive Zahl an");
		}
	}
	public String getNotiztext() {
		return notiztext;
	}
	public void setNotiztext(String notiztext) {
		if(notiztext.length()>3) {
			this.notiztext = notiztext;
		}
		else {
			System.out.println("Text ist zu kurz");
		}
	}
	public boolean isErledigt() {
		return erledigt;
	}
	public void setErledigt(boolean erledigt) {
		this.erledigt = erledigt;
	}
}
