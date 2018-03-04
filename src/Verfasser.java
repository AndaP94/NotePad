/**
* @author Andreas Pichler
*	KLasse des Verfassers
*/
public class Verfasser {

	private int verfasserNr;
	private String vorname;
	private String nachname;

	public Verfasser() {

		this.verfasserNr=1;
		this.vorname="";
		this.nachname="";

	}
	public Verfasser(int verfasserNr, String vorname, String nachname) {
		setVerfasserNr( verfasserNr);
		setVorname (vorname);
		setNachname( nachname);
	}

	public int getVerfasserNr() {
		return verfasserNr;
	}
	public void setVerfasserNr(int verfasserNr) {
		if(verfasserNr>0) {
			this.verfasserNr = verfasserNr;
		}
		else {
			System.out.println("Geben Sie eine posetive zahl an!");
		}
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		if(vorname.length()>3) {
			this.vorname = vorname;
		}
		else {
			System.out.println("Ihr Name ist leider zu kurz!");
		}
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		if(nachname.length()>3) {
			this.nachname = nachname;

		}
		else{
			System.out.println("Ihr Nachname ist zu kurz!");
		}
	}
}
